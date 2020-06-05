package com.advertisement.service;

import com.advertisement.model.Advertisement;

import java.util.List;

public interface AdvertisementService {


    void add(Advertisement ad);

    int findAllCount(Long ownerId);

    List<Advertisement> findAll();
}
