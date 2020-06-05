package com.rent.service.impl;


import com.core.commands.ReserveCommand;
import com.rent.dto.RentRequestDTO;
import com.rent.enumerations.RentRequestStatus;
import com.rent.model.RentRequest;
import com.rent.repository.RentRequestRepository;
import com.rent.service.RentRequestService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentRequestImpl implements RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Inject
    private transient CommandGateway commandGateway;

    //    @Override
//    public void update(Long id, String status) {
//        RentRequest req = this.rentRequestRepository.findById(id).orElse(null);
//        if (req != null) {
//            req.setStatus("PENDING");
//            this.rentRequestRepository.save(req);
//        }
//    }
//
    @Override
    public void rent(RentRequest rentRequest) {
        rentRequest.setRentRequestStatus(RentRequestStatus.RESERVED);
        System.out.println("Salje se komanda" + rentRequest.getId() + " sa" + rentRequest.getAdvertisementId());
        this.rentRequestRepository.save(rentRequest);
        commandGateway.send(new ReserveCommand(rentRequest.getId(), rentRequest.getRentRequestStatus().toString(), rentRequest.getStartDateTime().toString(), rentRequest.getEndDateTime().toString(), rentRequest.getAdvertisementId()));
        System.out.println("Poslata je komanda");
    }


    @Override
    public List<RentRequestDTO> getHistoryRentRequests(long id) {

        List<RentRequestDTO> historyList = new ArrayList<>();

        LocalDateTime dateTime = LocalDateTime.now();
        RentRequestStatus status = RentRequestStatus.PAID;
        List<RentRequest> historyListR = rentRequestRepository.findBySenderIdAndRentRequestStatusAndEndDateTimeGreaterThanEqual(id, status, dateTime);

        System.out.println(historyListR);
        for (RentRequest rr : historyListR) {
            historyList.add(new RentRequestDTO(rr));
        }

        System.out.println(historyList);
        return historyList;
    }

    @Override
    public List<RentRequestDTO> getCancelableRentRequests(long id) {

        List<RentRequestDTO> cancelableList = new ArrayList<>();

        List<RentRequestStatus> statuses = new ArrayList<>();
        statuses.add(RentRequestStatus.PENDING);
        statuses.add(RentRequestStatus.RESERVED);
        List<RentRequest> cancelableListR = rentRequestRepository.findBySenderIdAndRentRequestStatusIn(id, statuses);

        System.out.println(cancelableListR);
        for (RentRequest rr : cancelableListR) {
            cancelableList.add(new RentRequestDTO(rr));
        }

        return cancelableList;
    }

    @Override
    public void changeStatus(Long id, String status) {
        RentRequest rentRequest = this.rentRequestRepository.find(id);
        rentRequest.setRentRequestStatus(RentRequestStatus.valueOf(status));
        this.rentRequestRepository.save(rentRequest);
    }

    @Override
    public List<RentRequest> findPending(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return this.rentRequestRepository.findPending(id, startDate, endDate);
    }

    @Override
    public void save(RentRequest rentRequest) {
        this.rentRequestRepository.save(rentRequest);
    }


}
