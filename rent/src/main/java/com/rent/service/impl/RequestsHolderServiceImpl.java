package com.rent.service.impl;

import com.rent.dto.RequestsHolderDTO;
import com.rent.model.RequestsHolder;
import com.rent.repository.RequestsHolderRepository;
import com.rent.service.RequestsHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestsHolderServiceImpl implements RequestsHolderService {

    @Autowired
    private RequestsHolderRepository requestsHolderRepository;

    @Override
    public void save(RequestsHolder requestsHolder) {
        this.requestsHolderRepository.save(requestsHolder);
    }

    @Override
    public List<RequestsHolderDTO> getAllPending(Long id) {

        List<RequestsHolderDTO> requestsHolderDTOS = new ArrayList<>();
//        for (RequestsHolder req : this.requestsHolderRepository.getAllPending(id)) {
//            requestsHolderDTOS.add(new RequestsHolderDTO(req));
//        }
        return requestsHolderDTOS;
    }
}