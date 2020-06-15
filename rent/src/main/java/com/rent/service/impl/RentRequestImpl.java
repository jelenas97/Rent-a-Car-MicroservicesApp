package com.rent.service.impl;


import com.core.commands.ReserveCommand;
import com.rent.dto.RentRequestDTO;
import com.rent.enumerations.RentRequestStatus;
import com.rent.model.RentRequest;
import com.rent.repository.RentRequestRepository;
import com.rent.service.RentRequestService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RentRequestImpl implements RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Inject
    private transient CommandGateway commandGateway;

    @Override
    @Transactional
    public void rent(RentRequest rentRequest) {
        if (rentRequest.getRentRequestStatus().equals(RentRequestStatus.PENDING)) {
            rentRequest.setRentRequestStatus(RentRequestStatus.RESERVED);
            System.out.println("Salje se komanda" + rentRequest.getId() + " sa" + rentRequest.getAdvertisementId());
            this.save(rentRequest);
            String rentAggregateId = UUID.randomUUID().toString();
            commandGateway.send(new ReserveCommand(rentAggregateId, rentRequest.getId(), rentRequest.getRentRequestStatus().toString(), rentRequest.getStartDateTime().toString(), rentRequest.getEndDateTime().toString(), rentRequest.getAdvertisementId()));
            System.out.println("Poslata je komanda");
        }
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
    @Transactional
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

    @Override
    @Transactional
    //  @Scheduled(cron = "${every30sec.cron}")
    @Scheduled(cron = "${fourHours.cron}")
    public void cleanOldRequests() {
        System.out.println("Requests maintenance");
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        //for trying put every30sec.cron and use twoMinutes instead of yesterday
        //LocalDateTime twoMinutes = LocalDateTime.now().minusMinutes(2);
        List<RentRequest> requests = this.rentRequestRepository.findOldRequests(yesterday);
        System.out.println("Found : " + requests);
        for (RentRequest r : requests) {
            r.setRentRequestStatus(RentRequestStatus.CANCELED);
            this.save(r);
        }
    }


}
