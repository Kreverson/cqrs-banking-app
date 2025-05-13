package br.com.cqrs.banking.app.service.event;

import br.com.cqrs.banking.app.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);
}
