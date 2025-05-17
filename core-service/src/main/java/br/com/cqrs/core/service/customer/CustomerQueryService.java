package br.com.cqrs.core.service.customer;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.core.service.QueryService;

public interface CustomerQueryService extends QueryService<Customer> {

    Customer getByUsername(String username);

    boolean existsByUsername(String username);
}
