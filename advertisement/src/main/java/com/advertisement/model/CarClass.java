package com.advertisement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class CarClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean active = true;

    @JsonIgnore
    @OneToMany(mappedBy = "carClass", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Car> car;

    public CarClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
