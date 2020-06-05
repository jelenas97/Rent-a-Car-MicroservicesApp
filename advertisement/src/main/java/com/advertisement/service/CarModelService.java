package com.advertisement.service;

import com.advertisement.model.CarBrand;
import com.advertisement.model.CarModel;

import java.util.List;

public interface CarModelService {
    CarModel findOne(Long id);

    CarModel findOneByName(String name);

    List<CarModel> findAllActive(Long id);

    List<String> findAllStringList(Long brand);

    void save(String name, CarBrand brand);

    void delete(CarModel carModel);

    void setActive(String name);
}
