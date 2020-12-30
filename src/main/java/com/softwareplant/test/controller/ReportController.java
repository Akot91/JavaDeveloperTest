package com.softwareplant.test.controller;

import com.softwareplant.test.service.ReportService;
import com.softwareplant.test.dto.ReportDto;
import com.softwareplant.test.model.ReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete() {
        reportService.deleteAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{reportId}")
    public void delete(@PathVariable Long reportId) {
        reportService.delete(reportId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ReportDto> get() {
        return reportService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{reportId}")
    public ReportDto get(@PathVariable Long reportId) {
        return reportService.get(reportId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{reportId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@PathVariable Long reportId, @RequestBody ReportQuery reportQuery) {
        reportService.save(reportId, reportQuery);
    }
}
