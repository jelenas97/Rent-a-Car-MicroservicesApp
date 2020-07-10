package com.advertisement.service;

import com.advertisement.model.Report;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {

    List<Report> findAll();

    ResponseEntity<?> save(Report report);

}
