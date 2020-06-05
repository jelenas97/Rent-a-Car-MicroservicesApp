package com.advertisement.service;

import com.advertisement.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> findAll(Long agentID);

    Advertisement find(Long id);
}
