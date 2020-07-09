package com.statistics.controller;

import com.statistics.dto.RateDTO;
import com.statistics.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping(value = "/rate", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("http://localhost:4200")
public class RateController {

    @Autowired
    RateService rateService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity<?> rateAdvertisement(@RequestBody RateDTO dto) {

        try {
            long id = this.rateService.rateAdvertisement(dto);
            return new ResponseEntity(id, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="/{id}", produces="application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_CLIENT', 'ROLE_AGENT')")
    @PermitAll
    public ResponseEntity<?> getAverageAdvertisementRate(@PathVariable Long id){

        try {
            List<RateDTO> rates = this.rateService.findAverageAdvRate(id);

            return new ResponseEntity(rates, HttpStatus.OK);

        }catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while loading rates");
        }
    }

    @GetMapping(value="/{id}/first", produces="application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_CLIENT', 'ROLE_AGENT')")
    @PermitAll
    public RateDTO getAverageAdvertisementRateFirst(@PathVariable Long id){

        try {
            List<RateDTO> rates = this.rateService.findAverageAdvRate(id);
            if(rates.size() != 0) {
                return rates.get(0);
            } else {
                return  null;
            }
        }catch(NullPointerException e){
            return null;
        }
    }
}
