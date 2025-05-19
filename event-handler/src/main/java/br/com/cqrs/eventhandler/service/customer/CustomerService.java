package br.com.cqrs.eventhandler.service.customer;


import br.com.cqrs.common.domain.model.Customer;

import java.util.UUID;

public interface CustomerService {

    Customer create(Customer client);

    void addCard(UUID clientId, UUID cardId);
}
