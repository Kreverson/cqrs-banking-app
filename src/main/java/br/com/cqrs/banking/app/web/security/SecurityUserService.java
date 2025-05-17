package br.com.cqrs.banking.app.web.security;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final CustomerService customerService;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        Customer customer = customerService.getByUsername(username);
        return new SecurityUser(customer);
    }
}
