package br.com.cqrs.core.service.transaction;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.common.events.TransactionCreateEvent;
import br.com.cqrs.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private EventService eventService;

    @Override
    public void create(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}
