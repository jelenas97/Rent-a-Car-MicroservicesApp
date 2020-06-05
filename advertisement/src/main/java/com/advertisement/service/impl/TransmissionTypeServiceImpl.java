package com.advertisement.service.impl;

import com.advertisement.model.FuelType;
import com.advertisement.model.TransmissionType;
import com.advertisement.repository.TransmissionTypeRepository;
import com.advertisement.service.TransmissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransmissionTypeServiceImpl implements TransmissionTypeService {

    @Autowired
    private TransmissionTypeRepository transmissionTypeRepository;

    @Override
    public TransmissionType findOne(Long id) {
        return transmissionTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> findAllStringList()
    {
        List<String> stringList = transmissionTypeRepository.getActiveTransTypes().stream()
                .map( Object::toString )
                .collect( Collectors.toList() );
        return stringList;
    }

    @Override
    public TransmissionType findOneByName(String name) {
        return this.transmissionTypeRepository.findByName(name);
    }

    @Override
    public void save(String name) {
        this.transmissionTypeRepository.save(new TransmissionType(name));
    }

    @Override
    public void delete(TransmissionType transmissionType) {
        transmissionType.setActive(false);
        this.transmissionTypeRepository.save(transmissionType);
    }

    @Override
    public void setActive(String name) {
        TransmissionType transmissionType = this.transmissionTypeRepository.findByName(name);
        transmissionType.setActive(true);
        this.transmissionTypeRepository.save(transmissionType);
    }

    @Override
    public List<TransmissionType> findAll() {
        return this.transmissionTypeRepository.getActiveTransTypes();
    }

    @Override
    public List<TransmissionType> findAllActive() {
        return transmissionTypeRepository.getActiveTransTypes();
    }
}
