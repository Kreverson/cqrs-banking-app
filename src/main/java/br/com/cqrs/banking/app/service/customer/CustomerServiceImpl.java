package br.com.cqrs.banking.app.service.customer;

import br.com.cqrs.banking.app.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerQueryService queryService;
    private CustomerCommandService commandService;

    @Override
    public void create(Customer object) {
        commandService.create(object);
    }

    @Override
    public Customer getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return queryService.existsByUsername(username);
    }
}
