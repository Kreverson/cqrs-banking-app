package br.com.cqrs.banking.app.service.auth;

import br.com.cqrs.banking.app.domain.exception.ResourceAlreadyExistsException;
import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.customer.CustomerService;
import br.com.cqrs.banking.app.web.dto.LoginRequestDto;
import br.com.cqrs.banking.app.web.dto.LoginResponseDto;
import br.com.cqrs.banking.app.web.security.jwt.JwtProperties;
import br.com.cqrs.banking.app.web.security.jwt.TokenType;
import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CustomerService customerService;
    private final TokenService tokenService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        LoginResponseDto response = new LoginResponseDto();
        response.setAccess(
                tokenService. create(
                        TokenParameters.builder(
                                request.getUsername(),
                                TokenType.ACCESS.name(),
                                jwtProperties.getAccess()
                        ).build()
                )
        );

        response.setRefresh(
                tokenService. create(
                        TokenParameters.builder(
                                request.getUsername(),
                                TokenType.REFRESH.name(),
                                jwtProperties.getRefresh()
                        ).build()
                )
        );
        return response;
    }

    @Override
    public void register(Customer customer) {
        if(customerService.existsByUsername(customer.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerService.create(customer);
    }
}
