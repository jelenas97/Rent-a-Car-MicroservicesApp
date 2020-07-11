package com.rent.service;

import com.rent.dto.RequestsHolderDTO;
import com.rent.model.RequestsHolder;

import java.util.List;

public interface RequestsHolderService {
    RequestsHolder save(RequestsHolder requestsHolder);

    List<RequestsHolderDTO> getAllPending(Long id);

    List<com.rent.soap.code.RequestsHolderDTO> getAllPendingSoap(Long id);
    RequestsHolder findById(Long id);

    List<RequestsHolderDTO> getRequestHolders(Long id);
}