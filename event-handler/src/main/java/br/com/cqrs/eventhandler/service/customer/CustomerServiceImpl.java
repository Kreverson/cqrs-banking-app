package br.com.cqrs.eventhandler.service.customer;

import br.com.cqrs.common.domain.model.Account;
import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.common.repository.CustomerRepository;
import br.com.cqrs.eventhandler.service.account.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final AccountService accountService;

    @Override
    @Transactional
    public Customer create(
            final Customer customer) {
        Account account = new Account();
        account = accountService.create(account);
        customer.setAccount(account);
        return repository.save(customer);
    }

    @Override
    public void addCard(
            final UUID customerId,
            final UUID cardId) {

        repository.addCard(
                customerId.toString(),
                cardId.toString()
        );
    }
}
