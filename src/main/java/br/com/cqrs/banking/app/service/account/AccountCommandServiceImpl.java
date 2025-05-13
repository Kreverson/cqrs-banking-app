package br.com.cqrs.banking.app.service.account;

import br.com.cqrs.banking.app.domain.model.Account;
import br.com.cqrs.banking.app.events.AccountCreateEvent;
import br.com.cqrs.banking.app.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private EventService eventService;

    @Override
    public void create(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}
