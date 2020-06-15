package com.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


public class CreateTermCommand {
    @TargetAggregateIdentifier
    private String termAggregateId;
    private String rentAggregateId;
    private Long advertisementId;
    private String startDate;
    private String endDate;


    public CreateTermCommand() {
    }

    public CreateTermCommand(String rentAggregateId, String termAggregateId, Long advertisementId, String startDate, String endDate) {
        this.termAggregateId = termAggregateId;
        this.rentAggregateId = rentAggregateId;
        this.advertisementId = advertisementId;
        this.startDate = startDate;
        this.endDate = endDate;
        System.out.println("CORE API CREATE TERM COMMAN " + this.termAggregateId + this.advertisementId);
    }

    public String getTermAggregateId() {
        return termAggregateId;
    }

    public void setTermAggregateId(String termAggregateId) {
        this.termAggregateId = termAggregateId;
    }

    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRentAggregateId() {
        return rentAggregateId;
    }

    public void setRentAggregateId(String rentAggregateId) {
        this.rentAggregateId = rentAggregateId;
    }
}
