package com.advertisement.service;

import com.advertisement.model.CarBrand;

import java.util.List;

public interface CarBrandService {
    CarBrand findOne(Long id);

    CarBrand findOneByName(String name);

    List<String> findAllStringList();

    List<CarBrand> findAllActive();

    List<CarBrand> findAll();

    void save(String name);

    void delete(String name);

    void setActive(String name);
}
