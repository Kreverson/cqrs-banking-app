package br.com.cqrs.banking.app.web.controller;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.domain.model.Transaction;
import br.com.cqrs.banking.app.service.card.CardService;
import br.com.cqrs.banking.app.web.dto.CardDto;
import br.com.cqrs.banking.app.web.dto.TransactionDto;
import br.com.cqrs.banking.app.web.dto.mapper.CardMapper;
import br.com.cqrs.banking.app.web.dto.mapper.TransactionMapper;
import br.com.cqrs.banking.app.web.security.SecurityUser;
import br.com.cqrs.banking.app.web.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final SecurityService securityService;
    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByCustomerId(user.getId());
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(
        @PathVariable final UUID id
    ) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public List<TransactionDto> getTransactionsById(
        @PathVariable final UUID id
    ) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());

    }
}
