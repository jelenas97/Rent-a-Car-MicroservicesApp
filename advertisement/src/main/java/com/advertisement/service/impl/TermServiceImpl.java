package com.advertisement.service.impl;

import com.advertisement.model.Term;
import com.advertisement.repository.TermRepository;
import com.advertisement.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermServiceImpl implements TermService {
    @Autowired
    private TermRepository termRepository;

    @Override
    public void create(String aggId, Long advertisementId) {
        Term t = new Term();
        t.setProvjera("WORKING!!!");
        this.termRepository.save(t);
    }
}
