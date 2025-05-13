package br.com.cqrs.banking.app.service.transaction;

import br.com.cqrs.banking.app.domain.exception.ResourceNotFoundException;
import br.com.cqrs.banking.app.domain.model.Transaction;
import br.com.cqrs.banking.app.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    public TransactionQueryServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
