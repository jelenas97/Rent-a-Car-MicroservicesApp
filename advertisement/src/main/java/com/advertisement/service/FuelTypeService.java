package com.advertisement.service;

import com.advertisement.model.FuelType;

import java.util.List;

public interface FuelTypeService {
    FuelType findOne(Long id);

    FuelType findOneByName(String name);

    List<FuelType> findAll();

    List<FuelType> findAllActive();

    List<String> findAllStringList();

    void save(String name);

    void delete(String name);

    void setActive(String name);
}
