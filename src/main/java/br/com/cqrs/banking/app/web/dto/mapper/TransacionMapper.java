package br.com.cqrs.banking.app.web.dto.mapper;

import br.com.cqrs.banking.app.domain.model.Transaction;
import br.com.cqrs.banking.app.web.dto.TransactionDto;

public interface TransacionMapper extends Mappable<Transaction, TransactionDto> {
}
