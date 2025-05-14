package br.com.cqrs.banking.app.web.controller;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.auth.AuthService;
import br.com.cqrs.banking.app.web.dto.CustomerDto;
import br.com.cqrs.banking.app.web.dto.LoginRequestDto;
import br.com.cqrs.banking.app.web.dto.LoginResponseDto;
import br.com.cqrs.banking.app.web.dto.OnCreate;
import br.com.cqrs.banking.app.web.dto.mapper.CustomerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final CustomerMapper customerMapper;

    public AuthController(AuthService authService, CustomerMapper customerMapper) {
        this.authService = authService;
        this.customerMapper = customerMapper;
    }

    @PostMapping("/register")
    public void register(
            @RequestBody @Validated(OnCreate.class) final CustomerDto dto
            ) {
        Customer customer = customerMapper.fromDto(dto);
        authService.register(customer);
    }
    @PostMapping("/login")
    public LoginResponseDto login(
        @RequestBody @Validated(OnCreate.class) final LoginRequestDto dto
    ){
        return authService.login(dto);
    }
}
