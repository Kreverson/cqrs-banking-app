package br.com.cqrs.core.service.event;

import br.com.cqrs.common.events.AbstractEvent;
import br.com.cqrs.common.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements  EventService{

    private final EventRepository repository;

    @Override
    public void create(AbstractEvent event) {
        repository.save(event);
    }
}
