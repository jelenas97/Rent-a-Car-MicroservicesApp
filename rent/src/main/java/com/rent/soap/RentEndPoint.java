package com.rent.soap;

import com.rent.dto.RentRequestDTO;
import com.rent.service.RentRequestService;
import com.rent.service.RequestsHolderService;
import com.rent.soap.code.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Endpoint
public class RentEndPoint {

    private static final String NAMESPACE_URI = "http://localhost:8095/microservices/rent";

    @Autowired
    private RentRequestService rentRequestService;

    @Autowired
    private RequestsHolderService requestsHolderService;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRentRequestRequest")
    @ResponsePayload
    public GetRentRequestResponse getRentRequests(@RequestPayload GetRentRequestRequest request) {
        System.out.println("Soap request");

        List<RentRequestDTO> rentRequests = rentRequestService.getRentRequestReserved(request.getRentRequestId()); //userId ne RentRequest

        GetRentRequestResponse response = new GetRentRequestResponse();

        for(RentRequestDTO rrDTO : rentRequests) {
            RentRequest rr = new RentRequest();
            rr.setAdvertisementId(rrDTO.getAdvertisementId());
            rr.setEndDateString(rrDTO.getEndDateString());
            rr.setEndDateTime(rrDTO.getEndDateTime().toString());
            rr.setNumberOfUnseen(rrDTO.getNumberOfUnseen());
            rr.setId(rrDTO.getId());
            rr.setRentRequestStatus(rrDTO.getRentRequestStatus());
            rr.setSenderId(rrDTO.getSenderId());
            rr.setStartDateString(rrDTO.getStartDateString());
            rr.setStartDateTime(rrDTO.getStartDateTime().toString());
            response.getRentRequest().add(rr);
        }


        System.out.println("zavrsio request");
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRequestHoldersRequest")
    @ResponsePayload
    public GetRequestHoldersResponse getRequestHoldersResponse(@RequestPayload GetRequestHoldersRequest request) {

        GetRequestHoldersResponse response = new GetRequestHoldersResponse();

        List<com.rent.soap.code.RequestsHolderDTO> list = this.requestsHolderService.getAllPendingSoap(request.getId());

        for (com.rent.soap.code.RequestsHolderDTO holderDTO : list) {
            response.getRequestsHolder().add(holderDTO);
        }
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "confirmRequestHolderRequest")
    @ResponsePayload
    public ConfirmRequestHolderResponse confirmHolder(@RequestPayload ConfirmRequestHolderRequest request) {

        com.rent.dto.RequestsHolderDTO holderDTO = new com.rent.dto.RequestsHolderDTO();
        holderDTO.setBundle(request.getRequestsHolder().isBundle());
        holderDTO.setId(request.getRequestsHolder().getId());
        Set<RentRequestDTO> lista = new HashSet<RentRequestDTO>();

        for(RentRequest rr : request.getRequestsHolder().getRentRequests())
        {
            RentRequestDTO rrDto = new RentRequestDTO();
            rrDto.setAdvertisementId(rr.getAdvertisementId());
            rrDto.setCars(rr.getCars());
            rrDto.setId(rr.getId());
            rrDto.setEndDateString(rr.getEndDateString());
            rrDto.setStartDateString(rr.getStartDateString());
            rrDto.setEndDateTime(LocalDateTime.parse(rr.getEndDateTime()));
            rrDto.setStartDateTime(LocalDateTime.parse(rr.getStartDateTime()));
            rrDto.setNumberOfUnseen(rr.getNumberOfUnseen());
            rrDto.setRentRequestStatus(rr.getRentRequestStatus());
            rrDto.setSenderId(rr.getSenderId());

            lista.add(rrDto);

        }
        holderDTO.setRentRequests(lista);
        try {
            this.rentRequestService.processRequestsBundle(request.getConfirm(), holderDTO);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        ConfirmRequestHolderResponse response = new ConfirmRequestHolderResponse();
        response.setSuccess("success");
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "confirmRentRequestRequest")
    @ResponsePayload
    public ConfirmRentRequestResponse confirmRentRequest(@RequestPayload ConfirmRentRequestRequest request) {


        RentRequestDTO rrDto = new RentRequestDTO();
        rrDto.setAdvertisementId(request.getRequest().getAdvertisementId());
        rrDto.setCars(request.getRequest().getCars());
        rrDto.setId(request.getRequest().getId());
        rrDto.setEndDateString(request.getRequest().getEndDateString());
        rrDto.setStartDateString(request.getRequest().getStartDateString());
        rrDto.setEndDateTime(LocalDateTime.parse(request.getRequest().getEndDateTime()));
        rrDto.setStartDateTime(LocalDateTime.parse(request.getRequest().getStartDateTime()));
        rrDto.setNumberOfUnseen(request.getRequest().getNumberOfUnseen());
        rrDto.setRentRequestStatus(request.getRequest().getRentRequestStatus());
        rrDto.setSenderId(request.getRequest().getSenderId());




        try {
            this.rentRequestService.processRequest(request.getConfirm(),rrDto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        ConfirmRentRequestResponse response = new ConfirmRentRequestResponse();
        response.setSuccess("success");
        return response;

    }


}
