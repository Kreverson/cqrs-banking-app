package br.com.cqrs.banking.app.service.event;

import br.com.cqrs.banking.app.events.AbstractEvent;
import br.com.cqrs.banking.app.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
