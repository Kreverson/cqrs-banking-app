package br.com.cqrs.banking.app.events;

import br.com.cqrs.banking.app.domain.aggregate.Aggregate;
import br.com.cqrs.banking.app.domain.model.Customer;

public class CustomerCreateEvent extends AbstractEvent {

    public CustomerCreateEvent(Customer payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
