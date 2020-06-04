package com.advertisement.service.impl;


import com.advertisement.model.Advertisement;
import com.advertisement.repository.AdvertisementRepository;
import com.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public List<Advertisement> findAll(Long agentID) {
        LocalDate today = LocalDate.now();
        return this.advertisementRepository.findAll(today, agentID);
    }
}
