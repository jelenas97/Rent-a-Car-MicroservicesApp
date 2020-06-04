package com.rent.service;

import com.rent.dto.RequestsHolderDTO;
import com.rent.model.RequestsHolder;

import java.util.List;

public interface RequestsHolderService {
    void save(RequestsHolder requestsHolder);

    List<RequestsHolderDTO> getAllPending(Long id);
}