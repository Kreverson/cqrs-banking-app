package br.com.cqrs.banking.app.events;

import br.com.cqrs.banking.app.domain.aggregate.Aggregate;

public class CustomerCreateEvent extends AbstractEvent {

    public CustomerCreateEvent(Object payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
