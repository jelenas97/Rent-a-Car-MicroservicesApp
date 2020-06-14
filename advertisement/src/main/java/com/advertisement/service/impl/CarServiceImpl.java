package com.advertisement.service.impl;

import com.advertisement.model.Car;
import com.advertisement.repository.CarRepository;
import com.advertisement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
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
        String resourceFile =  "images/" + car.getId() + ".txt";
        System.out.print(resourceFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resourceFile))) {
            for (int i = 0; i < imageGallery.size(); i++) {
                bufferedWriter.write(imageGallery.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

    @Override
    public Car findById(String id) {
        Long carId = Long.parseLong(id);
        Car car = this.carRepository.findById(carId).orElse(null);
        car = loadImages(car);
        return car;
    }


    private Car loadImages(Car car) {
        String resourceFile = "images/" + car.getId() + ".txt";
        car.setImageGallery(new ArrayList<String>());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                car.getImageGallery().add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }

        return car;
    }

}
