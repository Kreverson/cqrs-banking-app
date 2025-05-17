package br.com.cqrs.core.service.card;

import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.common.events.CardCreateEvent;
import br.com.cqrs.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardCommandServiceImpl implements CardCommandService {

    private EventService eventService;

    @Override
    public void create(Card object) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }
}
