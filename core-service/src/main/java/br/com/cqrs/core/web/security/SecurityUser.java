package br.com.cqrs.core.web.security;

import br.com.cqrs.common.domain.model.Customer;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
public class SecurityUser implements UserDetails {

    private final UUID id;
    private final String username;
    private final String password;
    private final Collection<SimpleGrantedAuthority> authorities = List.of();

    public SecurityUser(final Customer user)
    {
        this(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );

        this.authorities.add(
                mapToGrantedAuthorities("ROLE_USER")
        );
    }

    private static SimpleGrantedAuthority mapToGrantedAuthorities(final String role) {
        return new SimpleGrantedAuthority(role);
    }

    private SecurityUser(
            final UUID id,
            final String username,
            final String password
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
