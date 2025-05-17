package br.com.cqrs.core.web.dto.mapper;

import br.com.cqrs.common.domain.model.Account;
import br.com.cqrs.core.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
