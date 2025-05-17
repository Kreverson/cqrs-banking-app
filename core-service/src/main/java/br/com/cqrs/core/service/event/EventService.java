package br.com.cqrs.core.service.event;

import br.com.cqrs.common.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);
}
