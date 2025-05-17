package br.com.cqrs.core.web.dto.mapper;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.core.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
