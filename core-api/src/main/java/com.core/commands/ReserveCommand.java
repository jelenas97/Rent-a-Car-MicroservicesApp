package com.core.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ReserveCommand {
    @TargetAggregateIdentifier
    private Long rentRequestId;
    private String status;

    public ReserveCommand() {
    }

    public ReserveCommand(Long rentRequestId,
                          String status) {
        this.rentRequestId = rentRequestId;
        this.status = status;
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
}
