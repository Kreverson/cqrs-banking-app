package br.com.cqrs.core.service.account;

import br.com.cqrs.common.domain.model.Account;
import br.com.cqrs.core.service.CommandService;
import br.com.cqrs.core.service.QueryService;

public interface AccountService
        extends QueryService<Account>, CommandService<Account> {
}
