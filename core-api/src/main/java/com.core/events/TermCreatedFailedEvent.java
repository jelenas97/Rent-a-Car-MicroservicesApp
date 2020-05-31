package com.core.events;

public class TermCreatedFailedEvent {

    private String termAggregateId;

    private String reason;

    public TermCreatedFailedEvent() {
    }

    public TermCreatedFailedEvent(String termAggregateId, String reason) {
        this.termAggregateId = termAggregateId;
        this.reason = reason;
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
}
