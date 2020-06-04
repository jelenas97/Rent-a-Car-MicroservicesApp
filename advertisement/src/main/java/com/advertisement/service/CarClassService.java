package com.advertisement.service;

import com.advertisement.model.CarClass;

import java.util.List;

public interface CarClassService {
    CarClass findOne(Long id);

    CarClass findOneByName(String name);

    List<CarClass> findAll();

    List<CarClass> findAllActive();

    List<String> findAllStringList();

    void save(String name);

    void delete(String name);

    void setActive(String name);
}
