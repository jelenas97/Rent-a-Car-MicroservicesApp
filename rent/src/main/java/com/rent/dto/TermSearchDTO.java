package com.rent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TermSearchDTO {
    private Long advertisementId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public TermSearchDTO(Long advertisementId, LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.advertisementId = advertisementId;
    }


}
