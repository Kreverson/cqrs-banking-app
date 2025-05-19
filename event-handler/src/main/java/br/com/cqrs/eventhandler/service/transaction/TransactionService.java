package br.com.cqrs.eventhandler.service.transaction;

import br.com.cqrs.common.domain.model.Transaction;

public interface TransactionService {

    Transaction create(Transaction transaction);

}
