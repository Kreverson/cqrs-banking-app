package br.com.cqrs.banking.app.events;

import br.com.cqrs.banking.app.domain.aggregate.Aggregate;

public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(Object payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
