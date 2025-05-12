package br.com.cqrs.banking.app.events;

import br.com.cqrs.banking.app.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);
}
