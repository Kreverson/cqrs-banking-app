package br.com.cqrs.banking.app.web.dto.mapper;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.web.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends Mappable<Customer, CustomerDto> {
}
