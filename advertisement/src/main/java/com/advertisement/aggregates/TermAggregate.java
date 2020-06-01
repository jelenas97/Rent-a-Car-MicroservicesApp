package com.advertisement.aggregates;

import com.advertisement.service.TermService;
import com.core.commands.CreateTermCommand;
import com.core.events.TermCreatedEvent;
import com.core.events.TermCreatedFailedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class TermAggregate {
    @TargetAggregateIdentifier
    private String termAggregateId;

    public TermAggregate() {
    }

    @CommandHandler
    public TermAggregate(CreateTermCommand createTermCommand, TermService termService) {
        try {

            termService.create(createTermCommand.getTermAggregateId(), createTermCommand.getAdvertisementId());

            AggregateLifecycle.apply(new TermCreatedEvent(createTermCommand.getTermAggregateId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            AggregateLifecycle.apply(new TermCreatedFailedEvent(createTermCommand.getTermAggregateId(), "RAZLOG", createTermCommand.getAdvertisementId()));
        }
    }

    @EventSourcingHandler
    protected void on(TermCreatedEvent termCreatedEvent) {
        this.termAggregateId = termCreatedEvent.getTermAggregateId();
    }

    @EventSourcingHandler
    protected void on(TermCreatedFailedEvent termCreatedFailedEvent) {
        this.termAggregateId = termCreatedFailedEvent.getTermAggregateId();
    }

}
