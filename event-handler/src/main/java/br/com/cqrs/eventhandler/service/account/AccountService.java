package br.com.cqrs.eventhandler.service.account;

import br.com.cqrs.common.domain.model.Account;

public interface AccountService {

    Account create(Account account);

}
