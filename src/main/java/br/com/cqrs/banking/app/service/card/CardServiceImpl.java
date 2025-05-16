package br.com.cqrs.banking.app.service.card;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final CustomerService customerService;

    @Override
    public void create(Card object) {
        commandService.create(object);
    }

    @Override
    public Card getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void createByCustomerId(UUID customerId) {
        Customer customer = customerService.getById(customerId);
        Card card = new Card(customer.getAccount());
        commandService.create(card);
    }

    @Override
    public boolean existsByNumberAndDate(String number, String date) {
        return queryService.existsByNumberAndDate(number, date);
    }
}
