package br.com.cqrs.core.service.transaction;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.core.service.CommandService;
import br.com.cqrs.common.service.QueryService;

public interface TransactionService
        extends QueryService<Transaction>, CommandService<Transaction> {
}
