package com.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateTermCommand {
    @TargetAggregateIdentifier
    private String termAggregateId;

    private Long advertisementId;


    public CreateTermCommand() {
    }

    public CreateTermCommand(String termAggregateId, Long advertisementId) {
        this.termAggregateId = termAggregateId;
        this.advertisementId = advertisementId;
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
}
