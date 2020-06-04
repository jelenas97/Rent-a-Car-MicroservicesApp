package com.advertisement.service.impl;


import com.advertisement.model.Advertisement;
import com.advertisement.repository.AdvertisementRepository;
import com.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public void add(Advertisement ad) {
        this.advertisementRepository.save(ad);
    }

    @Override
    public int findAllCount(Long id) {
        return this.advertisementRepository.findAllCount(id);
    }
}
