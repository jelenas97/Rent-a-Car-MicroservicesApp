package com.rent.model;

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
public class RequestsHolder {

    @OneToMany(mappedBy = "requests", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<RentRequest> rentRequests;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Boolean bundle;

    public RequestsHolder(Boolean bundle) {
        this.bundle = bundle;
    }
}
