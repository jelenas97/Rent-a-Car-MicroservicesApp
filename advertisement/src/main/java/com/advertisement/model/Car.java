package com.advertisement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    public CarClass carClass;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    public CarBrand carBrand;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    public CarModel carModel;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    public TransmissionType transmissionType;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
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
    @Transient
    private List<String> imageGallery;


}
