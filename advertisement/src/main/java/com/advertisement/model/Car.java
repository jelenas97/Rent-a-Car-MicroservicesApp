package com.advertisement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public CarClass carClass;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public CarBrand carBrand;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public CarModel carModel;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public TransmissionType transmissionType;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<FuelType> fuelType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    //    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    public Advertisement advertisement;
    @Column
    private Double rate;
    @Column
    private Integer mileage;
    @Column
    private Integer kidSeats;
    @Column
    private Boolean availableTracking;
    @Column
    private String image;


}
