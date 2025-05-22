package br.com.cqrs.eventhandler.service.card;

import br.com.cqrs.common.domain.exception.ResourceNotFoundException;
import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.common.repository.CardRepository;
import br.com.cqrs.common.service.customer.CustomerQueryService;
import br.com.cqrs.eventhandler.service.customer.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;
    private final CustomerQueryService customerQueryService;
    private final CustomerService clientService;

    @Override
    public Card getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Card create(Card card) {
        card.setCvv(generateCvv());
        card.setDate(generateDate());
        card.setNumber(generateNumber());
        repository.save(card);
        Customer customer = customerQueryService.getByAccount(
                card.getAccount().getId()
        );
        clientService.addCard(customer.getId(), card.getId());
        return card;
    }

    @Override
    @Transactional
    public void add(Card card, BigDecimal amount) {
        card.getAccount().setBalance(
                card.getAccount().getBalance().add(amount)
        );
        repository.save(card);
    }

    @Override
    @Transactional
    public void addTransaction(UUID cardId, UUID transactionId) {
        repository.addTransaction(
                cardId.toString(),
                transactionId.toString()
        );
    }

    private String generateCvv() {
        return String.valueOf(100 + (int) (Math.random() * 899));
    }

    private String generateDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = currentDate.plusYears(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        return expirationDate.format(formatter);
    }

    private String generateNumber() {
        return String.format(
                "%04d%04d%04d%04d",
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999)
        );
    }
}
