package com.advertisement.service;

import com.advertisement.model.Report;

import java.util.List;

public interface ReportService {

    List<Report> findAll();

    void save(Report report);

    List<Report> findAllByAd(Long id);
}
