package br.com.cqrs.banking.app.service.card;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.service.CommandService;
import br.com.cqrs.banking.app.service.QueryService;

public interface CardService
        extends QueryService<Card>, CommandService<Card> {
}
