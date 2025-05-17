package br.com.cqrs.core.service.account;

import br.com.cqrs.common.domain.model.Account;
import br.com.cqrs.common.events.AccountCreateEvent;
import br.com.cqrs.core.service.event.EventService;
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
