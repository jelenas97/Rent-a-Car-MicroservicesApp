package com.advertisement.dto;

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

    public RateDTO(RateDTO rateDTO) {
        this.id = rateDTO.getId();
        this.value = rateDTO.getValue();
        this.client = rateDTO.getClient();
        this.client_id = rateDTO.getClient_id();
        this.advertisement_id = rateDTO.getAdvertisement_id();
        this.rent_request_id = rateDTO.getRent_request_id();
        this.average_rate = rateDTO.getAverage_rate();
        this.voted = rateDTO.getVoted();
    }
}
