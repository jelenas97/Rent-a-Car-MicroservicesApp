package com.advertisement.controller;

import com.advertisement.dto.AdvertisementDTO;
import com.advertisement.dto.SearchDTO;
import com.advertisement.model.Advertisement;
import com.advertisement.model.CarModel;
import com.advertisement.model.FuelType;
import com.advertisement.model.Term;
import com.advertisement.repository.AdvertisementRepository;
import com.advertisement.repository.TermRepository;
import com.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "advertisement")
public class AdvertisementController {

    @Autowired
    private TermRepository termRepository;


    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private AdvertisementService advertisementService;

//    @GetMapping(path = "/test",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Term> getTerms() {
//        return this.termRepository.findAll();
//    }

    @GetMapping(path = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AdvertisementDTO getAdvertisement() {
        Advertisement ad = this.advertisementRepository.findById(1L).orElse(null);
        AdvertisementDTO advertisementDTO = new AdvertisementDTO(ad);
        System.out.print("Saljem ovaj advertisement " + advertisementDTO);
        return advertisementDTO;
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

    @GetMapping(produces = "application/json")
    @PermitAll
    public ResponseEntity<?> getAllAdvertisements() {
        try {
            List<Advertisement> ads = this.advertisementService.findAll();
            System.out.println(ads);
            List<AdvertisementDTO> adsDto = new ArrayList<>();
            for (Advertisement ad : ads) {
                adsDto.add(new AdvertisementDTO(ad));
            }
            return new ResponseEntity(adsDto, HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/searchAds", produces="application/json")
    @PermitAll
    public ResponseEntity<?> searchAdvertisements(@RequestBody SearchDTO searchDto){

        try {
            System.out.println("SearchDto: : "  + searchDto.toString());
            List<Advertisement> ads = this.advertisementService.search(searchDto);
            List<AdvertisementDTO> adsDto = new ArrayList<>();
            for(Advertisement ad : ads){
                adsDto.add(new AdvertisementDTO(ad));
            }
            return new ResponseEntity(adsDto, HttpStatus.OK);

        }catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during searching");
        }
    }


}
