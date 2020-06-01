package com.core.events;

public class ReservedEvent {

    private Long rentRequestId;
    private String status;

    public ReservedEvent() {
    }

    public ReservedEvent(Long rentRequestId,
                         String status) {
        this.rentRequestId = rentRequestId;
        this.status = status;
        System.out.println("CORE API RESERVE EVENT TERM COMMAN " + this.rentRequestId + this.status);

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
