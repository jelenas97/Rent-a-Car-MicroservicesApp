package com.advertisement.service.impl;

import com.advertisement.model.Car;
import com.advertisement.repository.CarRepository;
import com.advertisement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void add(Car car) {
        car.setName(car.getCarBrand() + " " + car.getCarModel());
        carRepository.save(car);
        saveImages(car.getImageGallery(), car);
    }


    private void saveImages(List<String> imageGallery, Car car) {
        String rootPath = System.getProperty("user.dir");
        String resourceFile = rootPath + "\\images\\" + car.getId() + ".txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resourceFile))) {
            for (int i = 0; i < imageGallery.size(); i++) {
                bufferedWriter.write(imageGallery.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

}
