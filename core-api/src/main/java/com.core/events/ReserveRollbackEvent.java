package com.core.events;

public class ReserveRollbackEvent {
    private Long rentRequestId;

    public ReserveRollbackEvent() {

    }

    public ReserveRollbackEvent(Long rentRequestId) {
        this.rentRequestId = rentRequestId;

        System.out.println("CORE API ROLBACK EVENT TERM COMMAN " + this.rentRequestId);

    }

    public Long getRentRequestId() {
        return rentRequestId;
    }

    public void setRentRequestId(Long rentRequestId) {
        this.rentRequestId = rentRequestId;
    }
}
