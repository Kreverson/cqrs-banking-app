package br.com.cqrs.core.service.customer;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.core.service.CommandService;
import br.com.cqrs.common.service.QueryService;

public interface CustomerService
        extends QueryService<Customer>, CommandService<Customer> {

    Customer getByUsername(String username);

    boolean existsByUsername(String username);
}
