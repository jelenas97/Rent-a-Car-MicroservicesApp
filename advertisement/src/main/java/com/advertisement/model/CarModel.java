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
public class CarModel {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public CarBrand carBrand;
    @OneToMany(mappedBy = "carModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Car> car;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean active = true;

    public CarModel(String name, CarBrand carBrand) {
        this.name = name;
        this.carBrand = carBrand;
    }

    @Override
    public String toString() {
        return name;
    }
}
