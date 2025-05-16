package br.com.cqrs.banking.app.web.controller;

import br.com.cqrs.banking.app.domain.model.Card;
import br.com.cqrs.banking.app.domain.model.Transaction;
import br.com.cqrs.banking.app.service.card.CardService;
import br.com.cqrs.banking.app.web.dto.CardDto;
import br.com.cqrs.banking.app.web.dto.TransactionDto;
import br.com.cqrs.banking.app.web.dto.mapper.CardMapper;
import br.com.cqrs.banking.app.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        UUID id = UUID.randomUUID();
        cardService.createByCustomerId(id);
    }

    @GetMapping("/{id}")
    public CardDto getById(
        @PathVariable final UUID id
    ) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsById(
        @PathVariable final UUID id
    ) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());

    }
}
