package com.advertisement.dto;

import com.advertisement.model.PriceList;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriceListDTO {

    private long id;
    private double pricePerDay;
    private double pricePerKm;
    private double cdw;
    private long creatorId;

    public PriceListDTO(double pricePerDay, double pricePerKm, double cdw, long creatorId) {
        this.pricePerDay = pricePerDay;
        this.pricePerKm = pricePerKm;
        this.cdw = cdw;
        this.creatorId = creatorId;
    }

    public PriceListDTO(PriceList priceList){
        this.creatorId=priceList.getCreatorId();
        this.pricePerDay=priceList.getPricePerDay();
        this.pricePerKm=priceList.getPricePerKm();
        this.cdw=priceList.getCdw();
        this.id=priceList.getId();
    }
}
