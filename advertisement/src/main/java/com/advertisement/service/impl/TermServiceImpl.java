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
        System.out.println("ADvertisement id:" + advertisementId);
        Advertisement ad = this.advertisementService.find(advertisementId);
        String[] startDateParts = startDate.split("-");
        String[] endDateParts = endDate.split("-");

        System.out.println("Ovo dobijam u terminu" + ad + startDate + endDate);
        LocalDate start = LocalDate.of(Integer.parseInt(startDateParts[0]), Integer.parseInt(startDateParts[1]),
                Integer.parseInt(startDateParts[2].split("T")[0]));
        LocalDate end = LocalDate.of(Integer.parseInt(endDateParts[0]), Integer.parseInt(endDateParts[1]),
                Integer.parseInt(endDateParts[2].split("T")[0]));
        System.out.println("Ovo dobijam u terminu" + start + end);
        Term t = new Term(start, end, ad);
        System.out.println(t.toString());
        this.termRepository.save(t);
    }
}
