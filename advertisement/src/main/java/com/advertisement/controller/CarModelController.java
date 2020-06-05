package com.advertisement.controller;

import com.advertisement.dto.CarModelDTO;
import com.advertisement.model.CarBrand;
import com.advertisement.model.CarModel;
import com.advertisement.service.CarBrandService;
import com.advertisement.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "model")
@CrossOrigin("http://localhost:4200")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;
    @Autowired
    private CarBrandService carBrandService;

    @PostMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> newModel(@RequestBody String name, @PathVariable String id) {

        try {
            CarModel carModel = this.carModelService.findOneByName(name);
            CarBrand carBrand = this.carBrandService.findOne(Long.parseLong(id));
            if (carModel != null) {
                this.carModelService.setActive(name);
            } else {
                this.carModelService.save(name, carBrand);
            }
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> deleteModel(@PathVariable String id) {

        try {
            CarModel carModel = this.carModelService.findOne(Long.parseLong(id));
            if (carModel != null) {
                this.carModelService.delete(carModel);
            }
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @PermitAll
    public ResponseEntity<?> getModels(@PathVariable String id) {

        try {
            CarBrand carBrand = this.carBrandService.findOne(Long.parseLong(id));
            List<CarModel> list = this.carModelService.findAllActive(carBrand.getId());

            List<CarModelDTO> carModelDtos = list.stream()
                    .map(carModel -> new CarModelDTO(carModel.getId(), carModel.getName()))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(carModelDtos, HttpStatus.OK);

        }catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missing brand name");
        }
    }
}
