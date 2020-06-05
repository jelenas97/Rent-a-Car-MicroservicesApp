package com.advertisement.controller;

import com.advertisement.client.AuthenticationClient;
import com.advertisement.dto.AdvertisementDTO;
import com.advertisement.dto.UserDTO;
import com.advertisement.model.Advertisement;
import com.advertisement.service.AdvertisementService;
import com.advertisement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "advertisement")
@CrossOrigin("http://localhost:4200")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private CarService carService;

    @Autowired
    private AuthenticationClient authenticationClient;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> addAdvertisement(@RequestBody Advertisement ad) {
        try {
            UserDTO userDTO = this.authenticationClient.getUser(ad.getOwnerId().toString());
            if (userDTO.getRoles().get(0).equals("ROLE_CLIENT")) {
                int numberOfAds = this.advertisementService.findAllCount(ad.getOwnerId());
                if (numberOfAds >= 3) {
                    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("You can not create more than 3 advertisement");
                }
            }
            this.carService.add(ad.getCar());
            this.advertisementService.add(ad);

            return ResponseEntity.ok().build();
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
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


}
