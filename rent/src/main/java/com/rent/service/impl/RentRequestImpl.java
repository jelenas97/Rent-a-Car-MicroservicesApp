package com.rent.service.impl;


import com.core.commands.ReserveCommand;
import com.rent.model.RentRequest;
import com.rent.repository.RentRequestRepository;
import com.rent.service.RentRequestService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RentRequestImpl implements RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Inject
    private transient CommandGateway commandGateway;

    @Override
    public void update(Long id, String status) {
        RentRequest req = this.rentRequestRepository.findById(id).orElse(null);
        if (req != null) {
            req.setStatus("PENDING");
            this.rentRequestRepository.save(req);
        }
    }

    @Override
    public void rent(RentRequest rentRequest) {
        rentRequest.setStatus("RESERVED <3");
        System.out.println("Salje se komanda");
        commandGateway.send(new ReserveCommand(rentRequest.getId(), rentRequest.getStatus()));
        System.out.println("Poslata je komanda");
    }


}
