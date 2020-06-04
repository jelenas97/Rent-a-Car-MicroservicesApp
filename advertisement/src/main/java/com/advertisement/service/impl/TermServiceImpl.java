package com.advertisement.service.impl;

import com.advertisement.model.Advertisement;
import com.advertisement.model.Term;
import com.advertisement.repository.TermRepository;
import com.advertisement.service.AdvertisementService;
import com.advertisement.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TermServiceImpl implements TermService {
    @Autowired
    private TermRepository termRepository;

    @Autowired
    private AdvertisementService advertisementService;

    @Override
    public void create(Long advertisementId, String startDate, String endDate) {
        //   Dobro provjeriti ovaj string i splitovanje!!!
        Advertisement ad = new Advertisement();
        String[] startDateParts = startDate.split(".");
        String[] endDateParts = endDate.split(".");
        LocalDate start = LocalDate.of(Integer.parseInt(startDateParts[0]), Integer.parseInt(startDateParts[0]),
                Integer.parseInt(startDateParts[0]));
        LocalDate end = LocalDate.of(Integer.parseInt(endDateParts[0]), Integer.parseInt(endDateParts[0]),
                Integer.parseInt(endDateParts[0]));
        Term t = new Term(start, end, ad);
        this.termRepository.save(t);
    }
}
