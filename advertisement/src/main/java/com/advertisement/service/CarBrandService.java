package com.advertisement.service;

import com.advertisement.model.Car;
import com.advertisement.model.CarBrand;

import java.util.List;

public interface CarBrandService {
    CarBrand findOne(Long id);

    CarBrand findOneByName(String name);

    List<String> findAllStringList();

    List<CarBrand> findAllActive();

    List<CarBrand> findAll();

    void save(String name);

    void delete(CarBrand carBrand);

    void setActive(String name);
}
