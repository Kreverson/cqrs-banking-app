package br.com.cqrs.banking.app.web.dto.mapper;

import br.com.cqrs.banking.app.domain.model.Account;
import br.com.cqrs.banking.app.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
