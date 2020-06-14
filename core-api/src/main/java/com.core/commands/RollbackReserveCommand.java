package com.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RollbackReserveCommand {
    @TargetAggregateIdentifier
    private String rentAggregateId;
    private Long rentRequestId;
    private String status;

    public RollbackReserveCommand() {
    }

    public RollbackReserveCommand(String rentAggregateId, Long rentRequestId, String status) {
        this.rentAggregateId = rentAggregateId;
        this.rentRequestId = rentRequestId;
        this.status = status;
        System.out.println("CORE API ROLLBACK TERM COMMAN " + this.rentRequestId + this.status);

    }

    public String getRentAggregateId() {
        return rentAggregateId;
    }

    public void setRentAggregateId(String rentAggregateId) {
        this.rentAggregateId = rentAggregateId;
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
