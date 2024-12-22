package com.example.Spring.Security.config.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * YOU CAN EXTENDS GENERICFILTER
 * extends OncePerRequestFilter
 */
public class MySecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MySecurityFilter before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MySecurityFilter after");
    }
}
