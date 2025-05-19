package br.com.cqrs.eventhandler.handler;

import br.com.cqrs.common.domain.model.Account;
import br.com.cqrs.common.events.AccountCreateEvent;
import br.com.cqrs.eventhandler.service.account.AccountService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        AccountCreateEvent event = gson.fromJson(
                object,
                AccountCreateEvent.class
        );
        Account account = gson.fromJson(
                (String) event.getPayload(),
                Account.class
        );
        accountService.create(account);
        acknowledgment.acknowledge();
    }
}
