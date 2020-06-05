package com.core.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ReserveCommand {
    private String rentAggregateId;
    @TargetAggregateIdentifier
    private Long rentRequestId;
    private String status;
    private String startDate;
    private String endDate;
    private Long advertisementId;
    public ReserveCommand() {
    }

    public ReserveCommand(Long rentRequestId, String status, String startDate, String endDate, Long advertisementId) {
        this.rentRequestId = rentRequestId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.advertisementId = advertisementId;

        System.out.println("CORE API RESERVE TERM COMMAN " + this.rentRequestId + this.status);

    }

    public Long getRentRequestId() {
        return rentRequestId;
    }

    public void setRentRequestId(Long rentRequestId) {
        this.rentRequestId = rentRequestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }
}
