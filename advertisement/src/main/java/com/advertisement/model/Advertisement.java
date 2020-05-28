package com.advertisement.model;

import javax.persistence.*;

@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer kilometresLimit;

    @Column
    private Integer discount;

    @Column
    private String place;

    public Advertisement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKilometresLimit() {
        return kilometresLimit;
    }

    public void setKilometresLimit(Integer kilometresLimit) {
        this.kilometresLimit = kilometresLimit;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
