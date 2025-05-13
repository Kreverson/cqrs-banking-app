package br.com.cqrs.banking.app.service.account;

import br.com.cqrs.banking.app.domain.model.Account;
import br.com.cqrs.banking.app.service.CommandService;

public interface AccountCommandService extends CommandService<Account> {
}
