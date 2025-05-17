package br.com.cqrs.common.events;

import br.com.cqrs.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);
}
