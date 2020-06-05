package com.advertisement.service;

import com.advertisement.model.TransmissionType;

import java.util.List;

public interface TransmissionTypeService {

    TransmissionType findOne(Long id);

    TransmissionType findOneByName(String name);

    List<TransmissionType> findAll();

    List<TransmissionType> findAllActive();

    List<String> findAllStringList();

    void save(String name);

    void delete(TransmissionType transmissionType);

    void setActive(String name);
}
