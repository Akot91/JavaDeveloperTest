package com.softwareplant.test.mapper;

import com.softwareplant.test.domain.Report;
import com.softwareplant.test.domain.ReportResult;
import com.softwareplant.test.dto.ReportDto;
import com.softwareplant.test.dto.ReportEntryDto;
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

    public ReportResult mapToReportResult(final ReportEntryDto reportEntryDto) {
        return new ReportResult(reportEntryDto.getFilmId(),
                reportEntryDto.getFilmName(),
                reportEntryDto.getCharacterId(),
                reportEntryDto.getCharacterName(),
                reportEntryDto.getPlanetId(),
                reportEntryDto.getPlanetName());
    }

    public ReportDto mapToReportDto(final Report report) {
        return new ReportDto(report.getId(),
                report.getQueryCriteriaCharacterPhrase(),
                report.getQueryCriteriaPlanetName(),
                mapToReportResultDto(report.getReportResult()));
    }

    public ReportEntryDto mapToReportResultDto(final ReportResult reportResult) {
        return new ReportEntryDto(reportResult.getFilmId(),
                reportResult.getFilmName(),
                reportResult.getCharacterId(),
                reportResult.getCharacterName(),
                reportResult.getPlanetId(),
                reportResult.getPlanetName());
    }

    public List<ReportDto> mapToReportDtoList(final List<Report> reports) {
        return reports.stream()
                .map(this::mapToReportDto)
                .collect(Collectors.toList());
    }

    public List<Report> mapToReportList(final List<ReportDto> reportsDto) {
        return reportsDto.stream()
                .map(this::mapToReport)
                .collect(Collectors.toList());
    }
}
