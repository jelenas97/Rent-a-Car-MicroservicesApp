package com.advertisement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Report", namespace = "http://localhost:8084/microservices/report")
@XmlRootElement(name = "reportClass")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Long id;

    @Column
    @XmlElement
    private Integer kilometers;

    @Column
    @XmlElement
    private String description;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "term_id", referencedColumnName = "id")
    @XmlElement
    private Term term;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "advertisement_id", referencedColumnName = "id")
    @XmlElement
    private Advertisement advertisement;

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", kilometers=" + kilometers +
                ", description='" + description + '\'' +
                ", term=" + term +
                ", advertisement=" + advertisement +
                '}';
    }
}
