package com.core.events;

public class TermCreatedFailedEvent {

    private String termAggregateId;
    private String rentAggregateId;
    private Long rentRequestId;
    private String reason;

    public TermCreatedFailedEvent() {
    }

    public TermCreatedFailedEvent(String rentAggregateId, String termAggregateId, String reason, Long rentRequestId) {
        this.termAggregateId = termAggregateId;
        this.rentAggregateId = rentAggregateId;
        this.reason = reason;
        this.rentRequestId = rentRequestId;
        System.out.println("CORE API TERM CREATED FAILED EVENT TERM COMMAN " + this.rentRequestId + this.rentRequestId);

    }

    public String getTermAggregateId() {
        return termAggregateId;
    }

    public void setTermAggregateId(String termAggregateId) {
        this.termAggregateId = termAggregateId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
