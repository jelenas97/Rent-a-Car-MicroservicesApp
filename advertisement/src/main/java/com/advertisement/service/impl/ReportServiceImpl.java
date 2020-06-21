package com.advertisement.service.impl;

import com.advertisement.model.Report;
import com.advertisement.repository.ReportRepository;
import com.advertisement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public void save(Report report) {
        reportRepository.save(report);
    }
}
