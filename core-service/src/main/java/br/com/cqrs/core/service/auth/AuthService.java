package br.com.cqrs.core.service.auth;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.core.web.dto.LoginRequestDto;
import br.com.cqrs.core.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto dto);
    void register(Customer customer);
}
