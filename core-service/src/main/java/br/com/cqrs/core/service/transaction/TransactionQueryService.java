package br.com.cqrs.core.service.transaction;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.core.service.QueryService;

public interface TransactionQueryService extends QueryService<Transaction> {
}
