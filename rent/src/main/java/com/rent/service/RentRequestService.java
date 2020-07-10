package com.rent.service;

import com.rent.dto.RentRequestDTO;
import com.rent.dto.RequestsHolderDTO;
import com.rent.model.RentRequest;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

public interface RentRequestService {

    void rent(RentRequest rentRequest);

    List<RentRequestDTO> getHistoryRentRequests(long id);

    List<RentRequestDTO> getCancelableRentRequests(long id);

    List<RentRequestDTO> getPaidRentRequests(long id);

    void changeStatus(Long id, String status);

    List<RentRequest> findPending(Long id, LocalDateTime startDate, LocalDateTime endDate);

    RentRequest save(RentRequest requestDTO);

    void cleanOldRequests();

    RentRequest findById(long id);

    List<RentRequestDTO> getRentRequestReserved(long id);

    RentRequest physicalRent(RentRequestDTO rentDTO) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException;

    RentRequestDTO cancelRentRequest(long id);

    void processRequest(String confirm, RentRequestDTO rentDTO) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException;

    void processRequestsBundle(String confirm, RequestsHolderDTO holderDTO) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException;

    void sendRequest(RequestsHolderDTO holderDTO);

    RentRequestDTO getRentRequest(String id);

    RentRequestDTO payRentRequest(long id);
}
