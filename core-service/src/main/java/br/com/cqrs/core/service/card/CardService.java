package br.com.cqrs.core.service.card;

import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.core.service.CommandService;
import br.com.cqrs.core.service.QueryService;

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
