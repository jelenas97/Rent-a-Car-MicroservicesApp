package com.rent.service.impl;


import com.core.commands.ReserveCommand;
import com.rent.client.AdvertisementClient;
import com.rent.client.StatisticsClient;
import com.rent.dto.CommentAndRateDTO;
import com.rent.dto.RentRequestDTO;
import com.rent.enumerations.RentRequestStatus;
import com.rent.model.RentRequest;
import com.rent.model.RequestsHolder;
import com.rent.repository.RentRequestRepository;
import com.rent.service.RentRequestService;
import com.rent.service.RequestsHolderService;
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
import java.util.stream.Collectors;

@Service
public class RentRequestImpl implements RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Inject
    private transient CommandGateway commandGateway;

    @Autowired
    private StatisticsClient statisticsClient;

    @Autowired
    private AdvertisementClient advertisementClient;

    @Autowired
    private RequestsHolderService requestsHolderService;




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
        List<RentRequest> historyListR = rentRequestRepository.findBySenderIdAndRentRequestStatusAndEndDateTimeLessThanEqual(id, status, dateTime);

        CommentAndRateDTO dto = statisticsClient.getCommentsAndRates(id);

        System.out.println(historyListR);
        for (RentRequest rr : historyListR) {

            String carClass= advertisementClient.getRentRequestsCarClass(rr.getAdvertisementId());
            historyList.add(new RentRequestDTO(rr, dto, carClass));
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

            String carClass= advertisementClient.getRentRequestsCarClass(rr.getAdvertisementId());
            cancelableList.add(new RentRequestDTO(rr, 0, carClass));
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

    @Override
    public RentRequest physicalRent(RentRequestDTO rentDTO) {
        System.out.println("Physical rent " + rentDTO);
        RentRequest req1 = new RentRequest(rentDTO, rentDTO.getSenderId(), rentDTO.getAdvertisementId(), null, RentRequestStatus.PENDING);
        this.save(req1);
        RentRequest req = this.rentRequestRepository.findById(req1.getId()).orElse(null);
        if (req != null) {
            this.rent(req);
        }
        //automatsko odbijanje
        List<RentRequest> rentRequests = this.findPending(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
        System.out.println("OVI SU VEC POSTOJALI: " + rentRequests);

        this.automaticRejection(rentRequests);
        return req;
    }

    @Override
    public RentRequestDTO cancelRentRequest(long id) {

        RentRequest rr = this.rentRequestRepository.find(id);
        rr.setRentRequestStatus(RentRequestStatus.CANCELED);
        this.rentRequestRepository.save(rr);
        String carClass= advertisementClient.getRentRequestsCarClass(rr.getAdvertisementId());
        RentRequestDTO rrDTO = new RentRequestDTO(rr, 0,carClass);

        return rrDTO;
    }

    public void automaticRejection(List<RentRequest> rentRequests) {
        for (RentRequest request : rentRequests) {
            RequestsHolder holder = this.requestsHolderService.findById(request.getRequests().getId());
            if (holder.getBundle()) {
                List<Long> listIds = holder.getRentRequests().stream()
                        .map(Object -> Object.getId())
                        .collect(Collectors.toList());
                for (Long id : listIds) {
                    System.out.println("Ovo je bilo u bundle uklanjam!!!" + id);
                    this.changeStatus(id, "CANCELED");
                }
            } else {
                this.changeStatus(request.getId(), "CANCELED");
            }
        }

    }


}
