package br.com.cqrs.common.service.customer;

import br.com.cqrs.common.domain.exception.ResourceNotFoundException;
import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.common.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final CustomerRepository repository;

    @Override
    public Customer getById(
            final UUID id
    ) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Customer getByUsername(
            final String username
    ) {
        return repository.findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(
            final String username
    ) {
        return repository.existsByUsername(username);
    }

    @Override
    public Customer getByAccount(
            final UUID accountId
    ) {
        return repository.findByAccountId(accountId)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
