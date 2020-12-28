package com.softwareplanttest.test.service;

import com.softwareplanttest.test.model.Report;
import com.softwareplanttest.test.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> getReport(Long id) {
        return reportRepository.findById(id);
    }

    public void saveNewReport(Report report) {
        reportRepository.save(report);
    }

    public void deleteAll() {
        reportRepository.deleteAll();
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }

}
