package com.rent.aggregates;

import com.core.commands.ReserveCommand;
import com.core.commands.RollbackReserveCommand;
import com.core.events.ReserveRollbackEvent;
import com.core.events.ReservedEvent;
import com.rent.service.RentRequestService;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

public class RentRequestAggregate {

    @AggregateIdentifier
    private Long rentRequestId;

    public RentRequestAggregate() {
    }

    @CommandHandler
    public RentRequestAggregate(ReserveCommand reserveCommand) {
        AggregateLifecycle.apply(new ReservedEvent(reserveCommand.getRentRequestId(),
                "RESERVED"));
    }

    @EventSourcingHandler
    public void on(ReservedEvent reservedEvent) {
        this.rentRequestId = reservedEvent.getRentRequestId();
    }

    @CommandHandler
    public void on(RollbackReserveCommand rollbackReserveCommand, RentRequestService requestService) {
        requestService.update(rollbackReserveCommand.getRentRequestId(), "PENDING");

        AggregateLifecycle.apply(new ReserveRollbackEvent(rollbackReserveCommand.getRentRequestId()));
    }

}
