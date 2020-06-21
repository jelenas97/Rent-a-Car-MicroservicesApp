package com.rent.service;

import com.rent.dto.RentRequestDTO;
import com.rent.model.RentRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface RentRequestService {

    void rent(RentRequest rentRequest);

    List<RentRequestDTO> getHistoryRentRequests(long id);

    List<RentRequestDTO> getCancelableRentRequests(long id);

    void changeStatus(Long id, String status);

    List<RentRequest> findPending(Long id, LocalDateTime startDate, LocalDateTime endDate);

    void save(RentRequest requestDTO);

    void cleanOldRequests();

    RentRequest findById(long id);

    List<RentRequestDTO> getRentRequestReserved(long id);

    RentRequest physicalRent(RentRequestDTO rentDTO);

    RentRequestDTO cancelRentRequest(long id);
}
