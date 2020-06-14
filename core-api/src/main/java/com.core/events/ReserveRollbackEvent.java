package com.core.events;

public class ReserveRollbackEvent {
    String rentAggregateId;
    private Long rentRequestId;

    public ReserveRollbackEvent() {

    }

    public ReserveRollbackEvent(String rentAggregateId, Long rentRequestId) {
        this.rentRequestId = rentRequestId;
        this.rentAggregateId = rentAggregateId;
        System.out.println("CORE API ROLBACK EVENT TERM COMMAN " + this.rentRequestId);

    }

    public Long getRentRequestId() {
        return rentRequestId;
    }

    public void setRentRequestId(Long rentRequestId) {
        this.rentRequestId = rentRequestId;
    }

    public String getRentAggregateId() {
        return rentAggregateId;
    }

    public void setRentAggregateId(String rentAggregateId) {
        this.rentAggregateId = rentAggregateId;
    }
}
