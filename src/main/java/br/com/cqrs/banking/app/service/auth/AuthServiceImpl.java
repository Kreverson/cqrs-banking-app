package br.com.cqrs.banking.app.service.auth;

import br.com.cqrs.banking.app.domain.exception.ResourceAlreadyExistsException;
import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.customer.CustomerService;
import br.com.cqrs.banking.app.web.dto.LoginRequestDto;
import br.com.cqrs.banking.app.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CustomerService customerService;

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        return new LoginResponseDto();
    }

    @Override
    public void register(Customer customer) {
        if(customerService.existsByUsername(customer.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }

        customer.setPassword(customer.getPassword());
        customerService.create(customer);
    }
}
