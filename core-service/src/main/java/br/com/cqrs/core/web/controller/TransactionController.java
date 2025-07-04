package br.com.cqrs.core.web.controller;

import br.com.cqrs.common.domain.model.Transaction;
import br.com.cqrs.core.service.card.CardService;
import br.com.cqrs.core.service.transaction.TransactionService;
import br.com.cqrs.core.web.dto.OnCreate;
import br.com.cqrs.core.web.dto.TransactionDto;
import br.com.cqrs.core.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
@Validated
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @PreAuthorize("@ssi.canAccessCard(#dto.from)")
    public void create(
            @RequestBody @Validated(OnCreate.class) final TransactionDto dto
    ) {
        if (!cardService.existsByNumberAndDate(
                dto.getTo().getNumber(),
                dto.getTo().getDate()
        )) {
            throw new IllegalStateException("Card does not exists");
        }

        Transaction transaction = transactionMapper.fromDto(dto);
        transactionService.create(transaction);
    }


    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public TransactionDto getById(
            @PathVariable final UUID id
    ) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }

}
