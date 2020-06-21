package com.advertisement.service.impl;

import com.advertisement.dto.CarDTO;
import com.advertisement.model.Advertisement;
import com.advertisement.model.Car;
import com.advertisement.repository.AdvertisementRepository;
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

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public void add(Car car) {
        car.setName(car.getCarBrand() + " " + car.getCarModel());
        car.setRate(0.0);
        carRepository.save(car);
        saveImagesLocal(car.getImageGallery(), car);
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

    private void saveImagesLocal(List<String> imageGallery, Car car) {
        String rootPath = System.getProperty("user.dir");
        String resourceFile = rootPath + "\\advertisement\\images\\" + car.getId() + ".txt";
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
    public CarDTO findById(String id) {
        Long carId = Long.parseLong(id);
        Car car = this.carRepository.findById(carId).orElse(null);
        car = loadImages(car);

        Advertisement a= advertisementRepository.findByCarId(carId);
        CarDTO carDTO = new CarDTO(car, a);
        return carDTO;
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

    private Car loadImagesLocally(Car car) {
        String rootPath = System.getProperty("user.dir");
        String resourceFile = rootPath + "\\advertisement\\images\\" + car.getId() + ".txt";
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
