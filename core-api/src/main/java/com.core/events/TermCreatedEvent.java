package com.core.events;

public class TermCreatedEvent {
    private String termAggregateId;

    public TermCreatedEvent() {
    }

    public TermCreatedEvent(String termAggregateId) {
        this.termAggregateId = termAggregateId;
    }

    public String getTermAggregateId() {
        return termAggregateId;
    }

    public void setTermAggregateId(String termAggregateId) {
        this.termAggregateId = termAggregateId;
    }
}

