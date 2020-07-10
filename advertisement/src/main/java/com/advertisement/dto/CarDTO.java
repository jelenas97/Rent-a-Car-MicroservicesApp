package com.advertisement.dto;

import com.advertisement.model.Advertisement;
import com.advertisement.model.Car;
import com.advertisement.model.FuelType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {
    private Long id;
    private String carBrand;
    private Set<FuelType> fuelType;
    private String carClass;
    private Integer limit;
    private String transmissionType;
    private Integer kidSeats;
    private Integer mileage;
    private List<String> imageGallery;
    private Boolean availableTracking;
    private String carModel;
    private Long advertisementId;
    private Long ownerId;
    private String name;

    public CarDTO(Car car, Advertisement a) {
        this.id = car.getId();
        this.carBrand = car.getCarBrand().getName();
        this.fuelType = car.getFuelType();
        this.carClass = car.getCarClass().getName();
        this.transmissionType = car.getTransmissionType().getName();
        this.kidSeats = car.getKidSeats();
        this.mileage = car.getMileage();
        this.imageGallery = car.getImageGallery();
        this.availableTracking = car.getAvailableTracking();
        this.carModel = car.getCarModel().getName();
        this.advertisementId= a.getId();
        this.ownerId=a.getOwnerId();
        this.name = car.getName();
    }
}
