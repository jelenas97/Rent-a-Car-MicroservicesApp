package com.advertisement.service;

import com.advertisement.dto.CarDTO;
import com.advertisement.model.Car;

public interface CarService {
    void add(Car car);

    CarDTO findById(String id);

    void sendLocation(String message);
}
