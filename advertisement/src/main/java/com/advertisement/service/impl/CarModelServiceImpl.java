package com.advertisement.service.impl;

import com.advertisement.model.CarBrand;
import com.advertisement.model.CarModel;
import com.advertisement.repository.CarModelRepository;
import com.advertisement.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public CarModel findOne(Long id) {
        return carModelRepository.findById(id).orElse(null);
    }
    @Override
    public List<String> findAllStringList(Long brand)
    {
        return carModelRepository.getActiveCarModels(brand).stream()
                .map( Object::toString )
                .collect( Collectors.toList() );
    }

    @Override
    public CarModel findOneByName(String name) {
        return this.carModelRepository.findByName(name);
    }

    @Override
    public void save(String name, CarBrand brand) {
        this.carModelRepository.save(new CarModel(name,brand));
    }

    @Override
    public void delete(String name) {
        CarModel carModel = this.carModelRepository.findByName(name);
        carModel.setActive(false);
        this.carModelRepository.save(carModel);

    }

    @Override
    public void setActive(String name) {
        CarModel carModel = this.carModelRepository.findByName(name);
        carModel.setActive(true);
        this.carModelRepository.save(carModel);
    }

    @Override
    public List<CarModel> findAllActive(Long id) {
        return carModelRepository.getActiveCarModels(id);
    }
}
