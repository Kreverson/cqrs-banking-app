package br.com.cqrs.banking.app.service.transaction;

import br.com.cqrs.banking.app.domain.model.Transaction;
import br.com.cqrs.banking.app.service.CommandService;
import br.com.cqrs.banking.app.service.QueryService;

public interface TransactionService
        extends QueryService<Transaction>, CommandService<Transaction> {
}
