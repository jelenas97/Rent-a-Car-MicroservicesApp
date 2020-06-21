package com.advertisement.controller;

import com.advertisement.dto.AdvertisementDTO;
import com.advertisement.dto.TermDTO;
import com.advertisement.dto.TermSearchDTO;
import com.advertisement.model.Term;
import com.advertisement.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "term")
public class TermController {
    @Autowired
    private TermService termService;

    @PostMapping(value = "/getTakenTerms", produces = "application/json")
    @PermitAll
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

    @GetMapping(consumes = "application/json", value = "/withReports")
    public List<TermDTO> getAllWithReports() {

        List<Term> terms = termService.getAllWithReports();
        List<TermDTO> termDTOS = new ArrayList<>();

        try {
            for (Term t : terms) {
                if (t.getReportWritten()) {
                    TermDTO termDTO = new TermDTO();
                    termDTO.setId(t.getId());
                    termDTO.setStartDate(t.getStartDate());
                    termDTO.setEndDate(t.getEndDate());

                    AdvertisementDTO advertisementDTO = new AdvertisementDTO();
                    advertisementDTO.setId(t.getAdvertisement().getId());
                    advertisementDTO.setCarBrand(t.getAdvertisement().getCar().getCarBrand().getName());
                    advertisementDTO.setName(t.getAdvertisement().getCar().getName());
                    advertisementDTO.setStartDate(t.getAdvertisement().getStartDate());
                    advertisementDTO.setEndDate(t.getAdvertisement().getEndDate());

                    termDTO.setAdvertisement(advertisementDTO);

                    termDTOS.add(termDTO);
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return termDTOS;
    }

    @GetMapping(value = "/agent/{id}", produces = "application/json")
    @PreAuthorize("hasRole('AGENT')")
    public List<TermDTO> getAllRentedFromCurrentAgent(@PathVariable Long id) {
        List<Term> rented = this.termService.getAllRentedFromCurrentAgent(id);
        List<TermDTO> termDTOS = new ArrayList<>();

        for (Term t : rented) {
            TermDTO termDTO = new TermDTO();
            termDTO.setId(t.getId());
            termDTO.setStartDate(t.getStartDate());
            termDTO.setEndDate(t.getEndDate());

            AdvertisementDTO advertisementDTO = new AdvertisementDTO();
            advertisementDTO.setId(t.getAdvertisement().getId());
            advertisementDTO.setName(t.getAdvertisement().getCar().getName());
            advertisementDTO.setCarBrand(t.getAdvertisement().getCar().getCarBrand().getName());
            advertisementDTO.setModel(t.getAdvertisement().getCar().getCarModel().getName());
            advertisementDTO.setStartDate(t.getAdvertisement().getStartDate());
            advertisementDTO.setEndDate(t.getAdvertisement().getEndDate());

            termDTO.setAdvertisement(advertisementDTO);

            termDTOS.add(termDTO);

        }

        System.out.println(termDTOS.size());
        return termDTOS;
    }

}
