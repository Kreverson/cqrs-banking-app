package br.com.cqrs.core.service.transaction;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.core.service.CommandService;

public interface TransactionCommandService extends CommandService<Transaction> {
}
