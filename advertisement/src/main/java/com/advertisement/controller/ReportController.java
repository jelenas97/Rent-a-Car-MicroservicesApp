package com.advertisement.controller;

import com.advertisement.model.Report;
import com.advertisement.model.Term;
import com.advertisement.service.ReportService;
import com.advertisement.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "report")
@CrossOrigin("http://localhost:4200")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private TermService termService;

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody Report report) {
        Term term = report.getTerm();
        term.setReportWritten(true);
        term.setAdvertisement(report.getAdvertisement());
        termService.save(term);
        reportService.save(report);
    }

    @GetMapping(produces = "application/json")
    public List<Report> getAll() {
        return reportService.findAll();
    }
}
