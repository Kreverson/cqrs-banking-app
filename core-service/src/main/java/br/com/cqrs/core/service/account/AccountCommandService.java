package br.com.cqrs.core.service.account;

import br.com.cqrs.common.domain.model.Account;
import br.com.cqrs.core.service.CommandService;

public interface AccountCommandService extends CommandService<Account> {
}
