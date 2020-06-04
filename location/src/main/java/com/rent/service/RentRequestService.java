package com.rent.service;

import com.rent.model.RentRequest;

public interface RentRequestService {
    void update(Long id, String status);

    void rent(RentRequest rentRequest);
}
