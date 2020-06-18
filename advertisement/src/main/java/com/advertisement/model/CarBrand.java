package com.advertisement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean active = true;

    @OneToMany(mappedBy = "carBrand", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    public Set<Car> car;

    @OneToMany(mappedBy = "carBrand", cascade = CascadeType.ALL)
    public Set<CarModel> carModels;

    public CarBrand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
