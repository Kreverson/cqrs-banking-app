package br.com.cqrs.banking.app.web.security.service;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessCustomer(UUID customerId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);
}
