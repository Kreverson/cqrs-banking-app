package br.com.cqrs.banking.app.service.customer;

import br.com.cqrs.banking.app.domain.exception.ResourceNotFoundException;
import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final CustomerRepository repository;

    public CustomerQueryServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
