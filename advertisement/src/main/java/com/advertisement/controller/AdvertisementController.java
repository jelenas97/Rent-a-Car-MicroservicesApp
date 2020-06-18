package com.advertisement.controller;

import com.advertisement.dto.AdvertisementDTO;
import com.advertisement.dto.SearchDTO;
import com.advertisement.model.Advertisement;
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
import com.advertisement.client.AuthenticationClient;
import com.advertisement.dto.UserDTO;
import com.advertisement.model.Advertisement;
import com.advertisement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "advertisement")
public class AdvertisementController {

    @Autowired
    private TermRepository termRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private AuthenticationClient authenticationClient;

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdvertisementDTO getAdvertisement(@PathVariable Long id) {
        Advertisement ad = this.advertisementService.find(id);
        AdvertisementDTO advertisementDTO = new AdvertisementDTO(ad);
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

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> addAdvertisement(@RequestBody Advertisement ad) {
            return this.advertisementService.add(ad);
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
