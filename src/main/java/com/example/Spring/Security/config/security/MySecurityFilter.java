package com.example.Spring.Security.config.security;

import jakarta.servlet.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;

/**
 * YOU CAN EXTENDS GENERICFILTER
 * extends OncePerRequestFilter
 */
public class MySecurityFilter implements Filter {
    UserDetails userDetailsService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MySecurityFilter before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MySecurityFilter after");
    }
}
