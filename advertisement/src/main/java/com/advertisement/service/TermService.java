package com.advertisement.service;

import com.advertisement.model.Term;

import java.time.LocalDateTime;
import java.util.List;

public interface TermService {
    void create(Long advertisementId, String startDate, String endDate);

    List<Term> findTakenTerms(Long id, LocalDateTime startDate, LocalDateTime endDate);
}
