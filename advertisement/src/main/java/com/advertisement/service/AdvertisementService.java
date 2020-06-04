package com.advertisement.service;

import com.advertisement.model.Advertisement;

public interface AdvertisementService {


    void add(Advertisement ad);

    int findAllCount(Long ownerId);
}
