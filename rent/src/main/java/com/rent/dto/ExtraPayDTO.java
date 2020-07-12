package com.rent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ExtraPayDTO {

    private LocalDate startDate;
    private LocalDate endDate;
    private long advertisementId;
    private long extraPayPrice;
}
