package br.com.cqrs.eventhandler.service.card;

import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.common.repository.CardRepository;
import br.com.cqrs.common.service.customer.CustomerQueryService;
import br.com.cqrs.eventhandler.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;
    private final CustomerQueryService customerQueryService;
    private final CustomerService clientService;

    @Override
    public Card getById(UUID id) {
        return null;
    }

    @Override
    public Card create(Card card) {
        return null;
    }

    @Override
    public void add(Card card, BigDecimal amount) {

    }

    @Override
    public void addTransaction(UUID cardId, UUID transactionId) {

    }
}
