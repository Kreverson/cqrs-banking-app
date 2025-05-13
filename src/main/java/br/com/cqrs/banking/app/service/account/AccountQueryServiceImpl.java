package br.com.cqrs.banking.app.service.account;

import br.com.cqrs.banking.app.domain.exception.ResourceNotFoundException;
import br.com.cqrs.banking.app.domain.model.Account;
import br.com.cqrs.banking.app.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
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
