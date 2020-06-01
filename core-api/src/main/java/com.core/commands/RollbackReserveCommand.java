package com.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RollbackReserveCommand {
    @TargetAggregateIdentifier
    private Long rentRequestId;
    private String status;

    public RollbackReserveCommand() {
    }

    public RollbackReserveCommand(Long rentRequestId,
                                  String status) {
        this.rentRequestId = rentRequestId;
        this.status = status;
        System.out.println("CORE API ROLLBACK TERM COMMAN " + this.rentRequestId + this.status);

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
