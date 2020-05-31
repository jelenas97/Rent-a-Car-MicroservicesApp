package com.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateTermCommand {
    @TargetAggregateIdentifier
    private String termAggregateId;


    public CreateTermCommand() {
    }

    public CreateTermCommand(String termAggregateId) {
        this.termAggregateId = termAggregateId;
    }

    public String getTermAggregateId() {
        return termAggregateId;
    }

    public void setTermAggregateId(String termAggregateId) {
        this.termAggregateId = termAggregateId;
    }

}
