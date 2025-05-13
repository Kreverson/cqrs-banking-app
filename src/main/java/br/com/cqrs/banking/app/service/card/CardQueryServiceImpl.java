package br.com.cqrs.banking.app.service.card;

import br.com.cqrs.banking.app.domain.exception.ResourceNotFoundException;
import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    public CardQueryServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Card getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
