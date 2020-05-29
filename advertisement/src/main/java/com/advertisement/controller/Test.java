package com.advertisement.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "test")
public class Test {

    @GetMapping(path = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAdvertisement() {
        return "ok saro";
    }
}
