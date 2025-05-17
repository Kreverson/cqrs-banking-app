package br.com.cqrs.core.web.controller;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.core.service.customer.CustomerService;
import br.com.cqrs.core.web.dto.AccountDto;
import br.com.cqrs.core.web.dto.CardDto;
import br.com.cqrs.core.web.dto.CustomerDto;
import br.com.cqrs.core.web.dto.mapper.AccountMapper;
import br.com.cqrs.core.web.dto.mapper.CardMapper;
import br.com.cqrs.core.web.dto.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCustomer(#id)")
    public CustomerDto getById(
            @PathVariable final UUID id
    ) {
        Customer customer = customerService.getById(id);
        return customerMapper.toDto(customer);
    }

    @GetMapping("/{id}/cards")
    @PreAuthorize("@ssi.canAccessCustomer(#id)")
    public List<CardDto> getCardsById(
            @PathVariable final UUID id
    ) {
        Customer customer = customerService.getById(id);
        return cardMapper.toDto(customer.getCards());
    }

    @GetMapping("/{id}/account")
    @PreAuthorize("@ssi.canAccessCustomer(#id)")
    public AccountDto getAccountById(
            @PathVariable final UUID id
    ) {
        Customer customer = customerService.getById(id);
        return accountMapper.toDto(customer.getAccount());
    }
}
