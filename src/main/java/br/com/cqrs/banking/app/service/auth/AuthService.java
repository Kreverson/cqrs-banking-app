package br.com.cqrs.banking.app.service.auth;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.web.dto.LoginRequestDto;
import br.com.cqrs.banking.app.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto dto);
    void register(Customer customer);
}
