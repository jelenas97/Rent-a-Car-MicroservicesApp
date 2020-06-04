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
}
