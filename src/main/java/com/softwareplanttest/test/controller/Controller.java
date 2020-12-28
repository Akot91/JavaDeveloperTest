package com.softwareplanttest.test.controller;

import com.softwareplanttest.test.domain.ReportDto;
import com.softwareplanttest.test.exception.NotFoundException;
import com.softwareplanttest.test.domain.Report;
import com.softwareplanttest.test.mapper.ReportMapper;
import com.softwareplanttest.test.model.ReportQuery;
import com.softwareplanttest.test.domain.ReportResult;
import com.softwareplanttest.test.service.DatabaseService;
import com.softwareplanttest.test.service.ReportCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/reports")
public class Controller {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private ReportCreator reportCreator;

    @Autowired
    private ReportMapper reportMapper;

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllReports() {
        databaseService.deleteAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{report_id}")
    public void deleteReport(@PathVariable Long report_id) {
        databaseService.deleteReport(report_id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ReportDto> getReports() {
        return reportMapper.mapToReportDtoList(databaseService.getAllReports());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{report_id}")
    public ReportDto getReport(@PathVariable Long report_id) throws NotFoundException {
        return reportMapper.mapToReportDto(databaseService.getReport(report_id).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{report_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createReport(@PathVariable Long report_id, @RequestBody ReportQuery reportQuery) {
        ReportResult result = reportCreator.prepareReport(reportQuery);
        Report report = new Report(report_id, reportQuery.getQueryCriteriaCharacterPhrase(), reportQuery.getQueryCriteriaPlanetName(), result);
        databaseService.saveNewReport(report);
    }
}
