package com.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateTermCommand {
    @TargetAggregateIdentifier
    private Long termAggregateId;


    public CreateTermCommand() {
    }

    public CreateTermCommand(Long termAggregateId) {
        this.termAggregateId = termAggregateId;
    }

    public Long getTermAggregateId() {
        return termAggregateId;
    }

    public void setTermAggregateId(Long termAggregateId) {
        this.termAggregateId = termAggregateId;
    }

}
