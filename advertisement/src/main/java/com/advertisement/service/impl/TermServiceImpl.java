package com.advertisement.service.impl;

import com.advertisement.model.Advertisement;
import com.advertisement.model.Term;
import com.advertisement.repository.TermRepository;
import com.advertisement.service.AdvertisementService;
import com.advertisement.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class TermServiceImpl implements TermService {
    @Autowired
    private TermRepository termRepository;

    @Autowired
    private AdvertisementService advertisementService;


    @Override
    @Transactional
    public void create(Long advertisementId, String startDate, String endDate) {
        //   Dobro provjeriti ovaj string i splitovanje!!!
        System.out.println("ADvertisement id:" + advertisementId);
        Advertisement ad = this.advertisementService.find(advertisementId);
        System.out.println(ad);
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

    @Override
    @Transactional
    public List<Term> findTakenTerms(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        LocalDate start = LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
        LocalDate end = LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth());
        System.out.println(id);
        return this.termRepository.findTakenTerm(id, start, end);

    }

    @Override
    public List<Term> getAllRentedFromCurrentAgent(Long id) {
        return termRepository.getAllRentedByAgentId(id);
    }

    @Override
    public List<Term> getAllWithReports() {
        return termRepository.getAllWithReports();
    }

    @Override
    public void save(Term term) {
        termRepository.save(term);
    }

}
