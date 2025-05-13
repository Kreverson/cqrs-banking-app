package br.com.cqrs.banking.app.service.account;

import br.com.cqrs.banking.app.domain.model.Account;
import br.com.cqrs.banking.app.service.CommandService;
import br.com.cqrs.banking.app.service.QueryService;

public interface AccountService
        extends QueryService<Account>, CommandService<Account> {
}
