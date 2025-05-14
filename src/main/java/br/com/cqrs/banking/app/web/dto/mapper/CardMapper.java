package br.com.cqrs.banking.app.web.dto.mapper;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.web.dto.CardDto;

public interface CardMapper extends Mappable<Card, CardDto> {
}
