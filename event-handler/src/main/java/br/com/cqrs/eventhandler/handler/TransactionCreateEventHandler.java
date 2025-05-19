package br.com.cqrs.eventhandler.handler;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.common.events.TransactionCreateEvent;
import br.com.cqrs.eventhandler.service.transaction.TransactionService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler {

    private final TransactionService transactionService;
    private final Gson gson;

    @Override
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        TransactionCreateEvent event = gson.fromJson(
                object,
                TransactionCreateEvent.class
        );
        Transaction transaction = gson.fromJson(
                (String) event.getPayload(),
                Transaction.class
        );
        transactionService.create(transaction);
        acknowledgment.acknowledge();
    }
}
