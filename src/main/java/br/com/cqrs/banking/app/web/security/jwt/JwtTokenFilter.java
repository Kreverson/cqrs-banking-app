package br.com.cqrs.banking.app.web.security.jwt;

import io.github.ilyalisov.jwt.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final TokenService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        try {
            String token = resolve((HttpServletRequest) servletRequest);
            if(
                    !token.isEmpty()
                    && jwtService.getType(token).equals(TokenType.ACCESS.name())
                    && !jwtService.isExpired(token)
            ) {
                Authentication authentication = getAuthentication(token);
                if(authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication((authentication));
                }
            }
        } catch (Exception ignored) {
        }
    }

    private String resolve(
            HttpServletRequest request
    ) {
      String bearerToken = request.getHeader("Authorization");
      if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
          return bearerToken.substring(7);
      }
      return "";
    }

    private Authentication getAuthentication(
            String token
    ) {
        String subject = jwtService.getSubject(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
        if(userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    userDetails,
                    userDetails.getAuthorities()
            );
        }
        return  null;
    }
}
