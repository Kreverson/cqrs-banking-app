package br.com.cqrs.core.service.customer;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.common.service.customer.CustomerQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerQueryService queryService;
    private final CustomerCommandService commandService;

    @Override
    public void create(Customer object) {
        commandService.create(object);
    }

    @Override
    public Customer getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public Customer getByUsername(String username) {
        return queryService.getByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return queryService.existsByUsername(username);
    }
}
