package br.com.cqrs.common.service.customer;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.common.service.QueryService;

import java.util.UUID;

public interface CustomerQueryService extends QueryService<Customer> {

    Customer getByUsername(String username);

    boolean existsByUsername(String username);

    Customer getByAccount(UUID accountId);
}
