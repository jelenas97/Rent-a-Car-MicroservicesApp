package com.advertisement.controller;

import com.advertisement.model.Advertisement;
import com.advertisement.model.Term;
import com.advertisement.repository.AdvertisementRepository;
import com.advertisement.repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "advertisement")
public class Test {

    @Autowired
    private TermRepository termRepository;


    @Autowired
    private AdvertisementRepository advertisementRepository;


//    @GetMapping(path = "/test",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Term> getTerms() {
//        return this.termRepository.findAll();
//    }

    @GetMapping(path = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAdvertisement() {
        System.out.print("Radi FEIGHNSDFFSDSDFWEFWRSDSDSEf");
        return "Axon server RADI!!!!";
    }


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<?> processRequest() {

        try {
            System.out.println("CREATE ADVERTISEMENT!!");
            Advertisement ad = new Advertisement();
            Term term = new Term();
            this.advertisementRepository.save(ad);
            this.termRepository.save(term);

            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }
}
