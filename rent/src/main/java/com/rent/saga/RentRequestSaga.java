package com.rent.saga;

import com.core.commands.CreateTermCommand;
import com.core.commands.RollbackReserveCommand;
import com.core.events.ReserveRollbackEvent;
import com.core.events.ReservedEvent;
import com.core.events.TermCreatedEvent;
import com.core.events.TermCreatedFailedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;
import java.util.UUID;

@Saga
public class RentRequestSaga {
    @Inject
    private transient CommandGateway commandGateway;


    @StartSaga
    @SagaEventHandler(associationProperty = "rentRequestId")
    public void handle(ReservedEvent reservedEvent) {
        System.out.println("Saga invoked second time??");

        String termAggregateId = UUID.randomUUID().toString();

        SagaLifecycle.associateWith("termAggregateId", termAggregateId);
        //ovdje vjerovatno ID advertisementa!!!!
        System.out.print(termAggregateId + reservedEvent.getRentRequestId());
        commandGateway.send(new CreateTermCommand(reservedEvent.getRentAggregateId(), termAggregateId, reservedEvent.getAdvertisementId(), reservedEvent.getStartDate(), reservedEvent.getEndDate()));
    }

    @SagaEventHandler(associationProperty = "termAggregateId")
    public void handle(TermCreatedEvent termCreatedEvent) {
        System.out.println("Saga finishing, created term!!!");

        SagaLifecycle.end();
    }

    @SagaEventHandler(associationProperty = "termAggregateId")
    public void handle(TermCreatedFailedEvent termCreatedFailedEvent) {
        System.out.println("Saga declined, starting compensation transaction!");
        commandGateway.send(new RollbackReserveCommand(termCreatedFailedEvent.getRentAggregateId(), termCreatedFailedEvent.getRentRequestId(), "PENDING"));

    }

    @SagaEventHandler(associationProperty = "rentRequestId")
    public void handle(ReserveRollbackEvent reserveRollbackEvent) {
        System.out.println("Saga finishing!");

        SagaLifecycle.end();
    }

}
