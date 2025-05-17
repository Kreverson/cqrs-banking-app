package br.com.cqrs.core.web.security;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.core.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
