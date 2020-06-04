package com.rent.aggregates;

import com.core.commands.ReserveCommand;
import com.core.commands.RollbackReserveCommand;
import com.core.events.ReserveRollbackEvent;
import com.core.events.ReservedEvent;
import com.rent.enumerations.RentRequestStatus;
import com.rent.service.RentRequestService;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RentRequestAggregate {

    @AggregateIdentifier
    private Long rentRequestId;

    public RentRequestAggregate() {
    }

    @CommandHandler
    public RentRequestAggregate(ReserveCommand reserveCommand) {
        System.out.println("RentRequestAggregate reserve command" + reserveCommand.toString());
        AggregateLifecycle.apply(new ReservedEvent(reserveCommand.getRentRequestId(),
                "RESERVED", reserveCommand.getStartDate(), reserveCommand.getEndDate()));
    }

    @EventSourcingHandler
    public void on(ReservedEvent reservedEvent) {
        System.out.println("RentRequestAggregate reserved event on" + reservedEvent.toString());
        this.rentRequestId = reservedEvent.getRentRequestId();
    }

    @CommandHandler
    public void on(RollbackReserveCommand rollbackReserveCommand, RentRequestService requestService) {
        System.out.println("RentRequestAggregate rollback command event on" + rollbackReserveCommand);
        requestService.changeStatus(rollbackReserveCommand.getRentRequestId(), RentRequestStatus.PENDING.toString());
        AggregateLifecycle.apply(new ReserveRollbackEvent(rollbackReserveCommand.getRentRequestId()));
    }

}
