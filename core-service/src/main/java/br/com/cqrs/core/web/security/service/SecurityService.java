package br.com.cqrs.core.web.security.service;

import br.com.cqrs.common.domain.model.Card;
import br.com.cqrs.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessCustomer(UUID customerId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);
}
