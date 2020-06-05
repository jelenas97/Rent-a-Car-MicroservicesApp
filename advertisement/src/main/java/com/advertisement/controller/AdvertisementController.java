package com.advertisement.controller;

import com.advertisement.dto.AdvertisementDTO;
import com.advertisement.model.Advertisement;
import com.advertisement.repository.TermRepository;
import com.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "advertisement")
public class AdvertisementController {
    @Autowired
    private TermRepository termRepository;

    @Autowired
    private AdvertisementService advertisementService;
//    @GetMapping(path = "/test",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Term> getTerms() {
//        return this.termRepository.findAll();
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AdvertisementDTO getAdvertisement() {
//        Advertisement ad = this.advertisementRepository.findById(1L).orElse(null);
        AdvertisementDTO advertisementDTO = new AdvertisementDTO();
        //     AdvertisementDTO advertisementDTO = new AdvertisementDTO(ad);
        System.out.print("Saljem ovaj advertisement " + advertisementDTO);
        return advertisementDTO;
    }

    @GetMapping(value = "/owner/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AdvertisementDTO> getUserAdvertisements(@PathVariable Long id) {

        List<Advertisement> advertisements = this.advertisementService.findAll(id);
        List<AdvertisementDTO> advertisementDTOS = new ArrayList<>();
        for (Advertisement a : advertisements) {
            advertisementDTOS.add(new AdvertisementDTO(a));
        }

        return advertisementDTOS;
    }


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<?> processRequest() {
        try {
//            System.out.println("CREATE ADVERTISEMENT!!");
//            Advertisement ad = new Advertisement();
//            Term term = new Term();
//            this.advertisementRepository.save(ad);
//            this.termRepository.save(term);

            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }
}


