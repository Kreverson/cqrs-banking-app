package br.com.cqrs.banking.app.service.customer;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.QueryService;

public interface CustomerQueryService extends QueryService<Customer> {

    boolean existsByUsername(String username);
}
