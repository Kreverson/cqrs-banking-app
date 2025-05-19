package br.com.cqrs.common.service.card;

import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.common.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
}
