package com.advertisement.service;
import com.advertisement.dto.SearchDTO;
import com.advertisement.model.Advertisement;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAll();
    List<Advertisement> search(SearchDTO dto);
    List<Advertisement> findAll(Long agentID);

    Advertisement find(Long id);
}
