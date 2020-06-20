package com.statistics.service;

import com.statistics.dto.RateDTO;

import java.util.List;

public interface RateService {

    long rateAdvertisement(RateDTO dto);
    List<RateDTO> findAverageAdvRate(long id);
}
