package br.com.cqrs.banking.app.service.card;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.service.CommandService;

public interface CardCommandService extends CommandService<Card> {
}
