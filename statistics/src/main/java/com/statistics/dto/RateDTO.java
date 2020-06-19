package com.statistics.dto;

import com.statistics.model.Rate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RateDTO {

    private long id;
    private long value;
    private long client_id;
    private String client;
    private long advertisement_id;
    private long rent_request_id;
    private float average_rate;
    private long voted;

    public RateDTO(Rate rate, float average, long voted, UserDTO dto){
        this.id = rate.getId();
        this.value = rate.getValue();
        this.client_id=rate.getClientId();
        this.advertisement_id = rate.getAdvertisementId();
        this.client= dto.getFirstName() +" "+ dto.getLastName();
        this.rent_request_id= rate.getRentRequestId();
        this.average_rate= average;
        this.voted= voted;
    }
}
