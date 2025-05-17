package br.com.cqrs.banking.app.service.customer;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.CommandService;
import br.com.cqrs.banking.app.service.QueryService;

public interface CustomerService
        extends QueryService<Customer>, CommandService<Customer> {

    Customer getByUsername(String username);

    boolean existsByUsername(String username);
}
