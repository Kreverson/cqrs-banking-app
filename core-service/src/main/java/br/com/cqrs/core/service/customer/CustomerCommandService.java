package br.com.cqrs.core.service.customer;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.core.service.CommandService;

public interface CustomerCommandService extends CommandService<Customer> {
}
