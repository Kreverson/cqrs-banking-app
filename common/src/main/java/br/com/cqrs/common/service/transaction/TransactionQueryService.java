package br.com.cqrs.common.service.transaction;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.common.service.QueryService;

public interface TransactionQueryService extends QueryService<Transaction> {
}
