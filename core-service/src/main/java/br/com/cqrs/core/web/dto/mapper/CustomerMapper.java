package br.com.cqrs.core.web.dto.mapper;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.core.web.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends Mappable<Customer, CustomerDto> {
}
