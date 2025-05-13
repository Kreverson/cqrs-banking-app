package br.com.cqrs.banking.app.service.transaction;

import br.com.cqrs.banking.app.domain.model.Transaction;
import br.com.cqrs.banking.app.events.TransactionCreateEvent;
import br.com.cqrs.banking.app.service.event.EventService;
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
