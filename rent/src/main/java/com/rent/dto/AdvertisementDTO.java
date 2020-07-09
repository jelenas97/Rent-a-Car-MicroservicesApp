package com.rent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdvertisementDTO {
    private Long id;
    private String name;
    private String carBrand;
    private String fuelType;
    private String carClass;
    private Integer kilometresLimit;
    private String transmissionType;
    private Boolean cwd;
    private Integer kidSeats;
    private Integer mileage;
    private Double rate;
    private Integer discount;
    private String image;
    private Boolean availableTracking;
    private Double price;
    private String model;
    private Long ownerId;
}
