package com.advertisement.dto;

import com.advertisement.model.Advertisement;
import com.advertisement.model.Term;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TermDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Period period;
    private Boolean canceled;
    private Long advertisementId;
    private AdvertisementDTO advertisement;

    public TermDTO(Term term) {
        this.startDate = term.getStartDate();
        this.endDate = term.getEndDate();
        this.period = Period.between(startDate, endDate);
        this.advertisementId = term.getAdvertisement().getId();
        this.canceled = term.getCanceled();
    }
}
