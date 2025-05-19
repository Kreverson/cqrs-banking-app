package br.com.cqrs.eventhandler.handler;

import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.common.events.CardCreateEvent;
import br.com.cqrs.eventhandler.service.card.CardService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;
    private final Gson gson;

    @Override
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        CardCreateEvent event = gson.fromJson(
                object,
                CardCreateEvent.class
        );
        Card card = gson.fromJson(
                (String) event.getPayload(),
                Card.class
        );
        cardService.create(card);
        acknowledgment.acknowledge();
    }
}
