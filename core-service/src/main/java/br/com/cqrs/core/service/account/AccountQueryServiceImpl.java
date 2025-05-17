package br.com.cqrs.core.service.account;

import br.com.cqrs.common.domain.exception.ResourceNotFoundException;
import br.com.cqrs.common.domain.model.Account;
import br.com.cqrs.common.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository repository;

    public AccountQueryServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
