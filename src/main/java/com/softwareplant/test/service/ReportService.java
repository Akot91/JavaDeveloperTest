package com.softwareplant.test.service;

import com.softwareplant.test.domain.Report;
import com.softwareplant.test.domain.ReportResult;
import com.softwareplant.test.dto.ReportDto;
import com.softwareplant.test.exception.ReportNotFoundException;
import com.softwareplant.test.mapper.ReportMapper;
import com.softwareplant.test.model.ReportQuery;
import com.softwareplant.test.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ReportDto get(final long id) {
        return reportRepository.findById(id).map(reportMapper::mapToReportDto).orElseThrow(() -> new ReportNotFoundException(id));
    }

    public void save(final long reportId, final ReportQuery reportQuery) {
        ReportResult result = reportCreator.prepareReport(reportQuery);
        Report report = new Report(reportId, reportQuery.getQueryCriteriaCharacterPhrase(), reportQuery.getQueryCriteriaPlanetName(), result);
        reportRepository.save(report);
    }

    public void deleteAll() {
        reportRepository.deleteAll();
    }

    public void delete(final long id) {
        if (reportRepository.findById(id).isPresent()) {
            reportRepository.deleteById(id);
        } else {
            throw new ReportNotFoundException(id);
        }
    }
}
