package com.example.Spring.Security.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;

public class MyAuthentificationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService customUserDetailsService;

    //IF WE DON T USER MEMORY
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();



        if(username.equals("admin") && password.equals("admin")){
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        }else{
            throw new  BadCredentialsException("Invalide userName");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
