package com.advertisement.controller;

import com.advertisement.dto.CarDTO;
import com.advertisement.model.Car;
import com.advertisement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "car")
@CrossOrigin("http://localhost:4200")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/{id}", produces = "application/json")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getCar(@PathVariable("id") String id) {

        try {
            Car car = this.carService.findById(id);
            CarDTO carDTO = new CarDTO(car);
            return new ResponseEntity(carDTO, HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not find car");
        }
    }
}
