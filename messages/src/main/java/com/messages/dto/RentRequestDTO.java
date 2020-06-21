package com.messages.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RentRequestDTO {

    private Long id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String startDateString;
    private String endDateString;
    private String rentRequestStatus;
    private String cars;
    private Long advertisementId;
    private Long senderId;
}
