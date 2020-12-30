package com.softwareplanttest.test.service;

import com.softwareplanttest.test.domain.Report;
import com.softwareplanttest.test.domain.ReportResult;
import com.softwareplanttest.test.dto.ReportDto;
import com.softwareplanttest.test.mapper.ReportMapper;
import com.softwareplanttest.test.model.ReportQuery;
import com.softwareplanttest.test.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    private final ReportMapper reportMapper;

    private final ReportCreator reportCreator;

    @Autowired
    public ReportService(ReportRepository reportRepository, ReportMapper reportMapper, ReportCreator reportCreator) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
        this.reportCreator = reportCreator;
    }

    public List<ReportDto> getAll() {
        return reportMapper.mapToReportDtoList(reportRepository.findAll());
    }

    public Optional<ReportDto> get(final long id) {
        return Optional.of(reportMapper.mapToReportDto(reportRepository.findById(id).get()));
    }

    public void save(final long reportId, final ReportQuery reportQuery) {
        ReportResult result = reportCreator.prepareReport(reportQuery);
        Report report = new Report(reportId, reportQuery.getQueryCriteriaCharacterPhrase(), reportQuery.getQueryCriteriaPlanetName(), result);
        reportRepository.save(report);
    }

    public void deleteAll() {
        reportRepository.deleteAll();
    }

    public void delete(final Long id) {
        reportRepository.deleteById(id);
    }
}