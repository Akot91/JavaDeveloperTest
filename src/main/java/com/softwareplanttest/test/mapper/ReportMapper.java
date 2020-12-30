package com.softwareplanttest.test.mapper;

import com.softwareplanttest.test.domain.Report;
import com.softwareplanttest.test.dto.ReportDto;
import com.softwareplanttest.test.domain.ReportResult;
import com.softwareplanttest.test.dto.ReportResultDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {

    public Report mapToReport(final ReportDto reportDto) {
        return new Report(reportDto.getId(),
                reportDto.getQueryCriteriaCharacterPhrase(),
                reportDto.getQueryCriteriaPlanetName(),
                mapToReportResult(reportDto.getReportResult()));
    }

    public ReportResult mapToReportResult(final ReportResultDto reportResultDto) {
        return new ReportResult(reportResultDto.getFilmId(),
                reportResultDto.getFilmName(),
                reportResultDto.getCharacterId(),
                reportResultDto.getCharacterName(),
                reportResultDto.getPlanetId(),
                reportResultDto.getPlanetName());
    }

    public ReportDto mapToReportDto(final Report report) {
        return new ReportDto(report.getId(),
                report.getQueryCriteriaCharacterPhrase(),
                report.getQueryCriteriaPlanetName(),
                mapToReportResultDto(report.getReportResult()));
    }

    public ReportResultDto mapToReportResultDto(final ReportResult reportResult) {
        return new ReportResultDto(reportResult.getFilmId(),
                reportResult.getFilmName(),
                reportResult.getCharacterId(),
                reportResult.getCharacterName(),
                reportResult.getPlanetId(),
                reportResult.getPlanetName());
    }

    public List<ReportDto> mapToReportDtoList(final List<Report> reports) {
        return reports.stream()
                .map(report -> mapToReportDto(report))
                .collect(Collectors.toList());
    }

    public List<Report> mapToReportList(final List<ReportDto> reportsDto) {
        return reportsDto.stream()
                .map(reportDto -> mapToReport(reportDto))
                .collect(Collectors.toList());
    }
}
