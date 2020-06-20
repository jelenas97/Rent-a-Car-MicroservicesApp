package com.rent.soap;

import com.rent.dto.RentRequestDTO;
import com.rent.enumerations.RentRequestStatus;
import com.rent.model.RentRequest;
import com.rent.model.RequestsHolder;
import com.rent.service.RentRequestService;
import com.rent.service.RequestsHolderService;
import com.rent.soap.code.PhysicalRentRequest;
import com.rent.soap.code.PhysicalRentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDateTime;
import java.util.HashSet;

@Endpoint
public class PhysicalRentEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8095/microservices/rent";

    @Autowired
    private RentRequestService rentRequestService;

    @Autowired
    private RequestsHolderService requestsHolderService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "physicalRentRequest")
    @ResponsePayload
    public PhysicalRentResponse physicalRentResponse(@RequestPayload PhysicalRentRequest request) {
        System.out.println("Soap request");


        PhysicalRentResponse response = new PhysicalRentResponse();
        RentRequest rentRequest = new RentRequest();

        LocalDateTime startDateTime = LocalDateTime.parse(request.getStartDateTime());

        LocalDateTime endDateTime = LocalDateTime.parse(request.getEndDateTime());

        LocalDateTime created = LocalDateTime.now();


        rentRequest.setVersion(0L);
        rentRequest.setStartDateTime(startDateTime);
        rentRequest.setEndDateTime(endDateTime);
        RentRequestStatus status = RentRequestStatus.valueOf(request.getRentRequestStatus().toString());
        rentRequest.setRentRequestStatus(status);
        rentRequest.setSenderId(request.getSenderId());
        rentRequest.setAdvertisementId(request.getAdvertisementId());
        rentRequest.setCreated(created);

        RequestsHolder holder = new RequestsHolder();
        holder.setBundle(false);
        HashSet<RentRequest> requests = new HashSet<>();
        RequestsHolder saved = requestsHolderService.save(holder);


        requests.add(rentRequest);
        holder.setRentRequests(requests);


        rentRequest.setRequests(saved);

        RentRequestDTO rentRequestDTO = new RentRequestDTO(rentRequest);


        RentRequest posted = rentRequestService.physicalRent(rentRequestDTO);


        response.setAdvertisementId(posted.getId());
        response.setHolderId(saved.getId());


        System.out.println("zavrsio request");
        return response;

    }
}
