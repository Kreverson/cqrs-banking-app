package br.com.cqrs.core.web.dto.mapper;

import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.core.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
