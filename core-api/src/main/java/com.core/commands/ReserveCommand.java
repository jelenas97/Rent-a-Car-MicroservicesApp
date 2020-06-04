package com.core.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ReserveCommand {
    @TargetAggregateIdentifier
    private Long rentRequestId;
    private String status;
    private String startDate;
    private String endDate;

    public ReserveCommand() {
    }

    public ReserveCommand(Long rentRequestId, String status, String startDate, String endDate) {
        this.rentRequestId = rentRequestId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;

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
}
