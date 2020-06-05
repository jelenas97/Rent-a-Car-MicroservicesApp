package com.advertisement.controller;

import com.advertisement.dto.TermDTO;
import com.advertisement.dto.TermSearchDTO;
import com.advertisement.model.Term;
import com.advertisement.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "term")
public class TermController {
    @Autowired
    private TermService termService;

    @PostMapping(value = "/getTakenTerms", produces = "application/json")
    public List<TermDTO> getTakenTerms(@RequestBody TermSearchDTO termSearchDTO) {
        try {
            List<Term> terms = this.termService.findTakenTerms(termSearchDTO.getAdvertisementId(), termSearchDTO.getStartDate(), termSearchDTO.getEndDate());
            List<TermDTO> termDTOS = new ArrayList<>();
            for (Term term : terms) {
                termDTOS.add(new TermDTO(term));
            }
            System.out.println("Sending term dtos:" + termDTOS);
            return termDTOS;

        } catch (NullPointerException e) {
            return null;
        }
    }

}
