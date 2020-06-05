package com.advertisement.service.impl;

import com.advertisement.model.CarBrand;
import com.advertisement.repository.CarBrandRepository;
import com.advertisement.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Override
    public CarBrand findOne(Long id) {
        return carBrandRepository.findById(id).orElse(null);
    }

    @Override
    public CarBrand findOneByName(String name) {
        return carBrandRepository.findByName(name);
    }

    @Override
    public List<String> findAllStringList() {
        return carBrandRepository.getActiveCarBrands().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarBrand> findAll() {
        return carBrandRepository.getActiveCarBrands();
    }

    @Override
    public void save(String name) {
        this.carBrandRepository.save(new CarBrand(name));
    }

    @Override
    public void delete(CarBrand carBrand) {
        carBrand.setActive(false);
        this.carBrandRepository.save(carBrand);
    }

    @Override
    public void setActive(String name) {
        CarBrand carBrand = this.carBrandRepository.findByName(name);
        carBrand.setActive(true);
        this.carBrandRepository.save(carBrand);
    }

    @Override
    public List<CarBrand> findAllActive() {
        return carBrandRepository.getActiveCarBrands();
    }
}
