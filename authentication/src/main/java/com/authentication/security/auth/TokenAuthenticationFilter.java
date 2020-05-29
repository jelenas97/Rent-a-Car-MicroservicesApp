package com.authentication.security.auth;

import com.authentication.security.TokenUtils;
import com.authentication.service.impl.CustomUserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenUtils tokenUtils;

    private final CustomUserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenHelper, CustomUserDetailsService userDetailsService) {
        this.tokenUtils = tokenHelper;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String username;
        String authToken = tokenUtils.getToken(httpServletRequest);

        if (authToken != null) {
            username = tokenUtils.getUsernameFromToken(authToken); //prima jwt token

            if (username != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // proveri da li je prosledjeni token validan
                if (tokenUtils.validateToken(authToken, userDetails)) {
                    // kreiraj autentifikaciju
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        // prosledi request dalje u sledeci filter
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
