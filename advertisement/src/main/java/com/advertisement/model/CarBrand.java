package com.advertisement.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;
@Entity
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "carBrandClass")
public class CarBrand {
    @OneToMany(mappedBy = "carBrand", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)

    public Set<Car> car;

    @OneToMany(mappedBy = "carBrand", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    public Set<CarModel> carModels;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean active = true;

    public CarBrand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
