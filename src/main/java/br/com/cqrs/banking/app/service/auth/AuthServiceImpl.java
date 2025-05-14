package br.com.cqrs.banking.app.service.auth;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.web.dto.LoginRequestDto;
import br.com.cqrs.banking.app.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        return new LoginResponseDto();
    }

    @Override
    public void register(Customer customer) {

    }
}
