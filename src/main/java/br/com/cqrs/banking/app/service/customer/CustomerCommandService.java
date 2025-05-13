package br.com.cqrs.banking.app.service.customer;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.CommandService;

public interface CustomerCommandService extends CommandService<Customer> {
}
