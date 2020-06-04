package com.advertisement.controller;

import com.advertisement.client.AuthenticationClient;
import com.advertisement.dto.UserDTO;
import com.advertisement.model.Advertisement;
import com.advertisement.service.AdvertisementService;
import com.advertisement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
            UserDTO userDTO = this.authenticationClient.findById(ad.getOwnerId());
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


}
