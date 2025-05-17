package br.com.cqrs.banking.app.service.card;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.service.CommandService;
import br.com.cqrs.banking.app.service.QueryService;

import java.util.UUID;

public interface CardService
        extends QueryService<Card>, CommandService<Card> {

    void createByCustomerId(UUID customerId);

    boolean existsByNumberAndDate(
            String number,
            String date
    );

    Card getByNumberAndDateAndCvv (
            String number,
            String date,
            String cvv
    );
}
