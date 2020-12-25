package com.softwareplanttest.test.repository;

import com.softwareplanttest.test.model.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, Long> {

    @Override
    List<Report> findAll();

    @Override
    Optional<Report> findById(Long id);

    @Override
    Report save(Report report);

    @Override
    void deleteAll();

    @Override
    void deleteById(Long id);
}
