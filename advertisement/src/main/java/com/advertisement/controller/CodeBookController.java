package com.advertisement.controller;

import com.advertisement.dto.*;
import com.advertisement.model.CarBrand;
import com.advertisement.model.CarClass;
import com.advertisement.model.FuelType;
import com.advertisement.model.TransmissionType;
import com.advertisement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "codebook")
@CrossOrigin("http://localhost:4200")
public class CodeBookController {


    @Autowired
    private CarBrandService carBrandService;

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private CarClassService carClassService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private TransmissionTypeService transTypeService;

    @Autowired
    private PriceListService priceListService;


    @GetMapping(value = "/getCodeBookInfo", produces = "application/json")
    @PermitAll
    public ResponseEntity<?> getCodeBookInfo() {
        System.out.println("POYYY FROM CODEBOOK");
        try {
            List<CarBrand> carBrands = this.carBrandService.findAllActive();
            List<CarClass> carClasses = this.carClassService.findAllActive();
            List<FuelType> fuelTypes = this.fuelTypeService.findAllActive();
            List<TransmissionType> transmissionTypes = this.transTypeService.findAllActive();

            List<CarClassDTO> carClassDtos = carClasses.stream()
                    .map(carClass -> new CarClassDTO(carClass.getId(), carClass.getName()))
                    .collect(Collectors.toList());

            List<CarBrandDTO> carBrandDtos = carBrands.stream()
                    .map(carBrand -> new CarBrandDTO(carBrand.getId(), carBrand.getName()))
                    .collect(Collectors.toList());

            List<FuelTypeDTO> fuelTypeDtos = fuelTypes.stream()
                    .map(fuelType -> new FuelTypeDTO(fuelType.getId(), fuelType.getName()))
                    .collect(Collectors.toList());

            List<TransmissionTypeDTO> transmissionTypeDtos = transmissionTypes.stream()
                    .map(transmissionType -> new TransmissionTypeDTO(transmissionType.getId(), transmissionType.getName()))
                    .collect(Collectors.toList());

            CodeBookDTO codeBook = new CodeBookDTO(carBrandDtos, carClassDtos, fuelTypeDtos, transmissionTypeDtos);

            return new ResponseEntity<>(codeBook, HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value = "/getCodeBookInfoModel/{id}", produces = "application/json")
    //@PreAuthorize("hasRole('ADMIN')"
    public ResponseEntity<?> getCodeBookInfoModel(@PathVariable("id") Long id) {
        try {
            System.out.print("OVO JE ID: " + id);

            List<CarBrand> carBrands = this.carBrandService.findAllActive();
            List<CarClass> carClasses = this.carClassService.findAllActive();
            List<FuelType> fuelTypes = this.fuelTypeService.findAllActive();
            List<TransmissionType> transmissionTypes = this.transTypeService.findAllActive();
            List<PriceListDTO> priceLists = this.priceListService.getCreatorsPriceLists(id);
            System.out.print(priceLists);
            CodeBookModelDTO codeBook = new CodeBookModelDTO(carBrands, carClasses, fuelTypes, transmissionTypes, priceLists);
            System.out.print(codeBook);

            return new ResponseEntity(codeBook, HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
