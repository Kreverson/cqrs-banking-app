package br.com.cqrs.banking.app.web.security.service;

import br.com.cqrs.banking.app.domain.exception.ResourceNotFoundException;
import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.domain.model.Transaction;
import br.com.cqrs.banking.app.service.card.CardService;
import br.com.cqrs.banking.app.service.customer.CustomerService;
import br.com.cqrs.banking.app.service.transaction.TransactionService;
import br.com.cqrs.banking.app.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final CustomerService customerService;
    private final CardService cardService;
    private final TransactionService transactionService;


    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }

        return (SecurityUser)  authentication.getPrincipal();
    }

    @Override
    public boolean canAccessCustomer(UUID customerId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        return  customerId.equals(id);
    }

    @Override
    public boolean canAccessCard(UUID cardId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Customer customer = customerService.getById(id);

        return customer.getCards().stream()
                .anyMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(Card card) {
        try {
            Card foundCard = cardService.getByNumberAndDateAndCvv(
                    card.getNumber(),
                    card.getDate(),
                    card.getCvv()
            );
            return canAccessCard(foundCard.getId());
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(UUID transactionId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Customer customer = customerService.getById(id);
        Transaction transaction = transactionService.getById(transactionId);

        return customer.getCards().contains(transaction.getFrom())
                || customer.getCards().contains(transaction.getTo());
    }
}
