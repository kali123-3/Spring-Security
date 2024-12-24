package com.example.Spring.Security.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class MySecurityConfig  {

   /* @Bean
    UserDetailsService userDetailsService(){
        Collection<UserDetails> users = new ArrayList<>();
        Collection<GrantedAuthority> authorities1 = new ArrayList<>();
        Collection<GrantedAuthority> authorities2 = new ArrayList<>();

        authorities1.add(new SimpleGrantedAuthority("ROLE_"+"red" ));
        authorities2.add(new SimpleGrantedAuthority("ROLE_"+"red" ));
        users.add(new User("user", passwordEncoder().encode("password1"), authorities1));
        users.add(new User("admin", passwordEncoder().encode("password2"), authorities2));
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(users);
        return inMemoryUserDetailsManager;
    }*/
/*
User detail manager permet de de creer user
    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        return users;
    }*/

    @Bean
    PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(
                 authorize -> authorize
                .anyRequest().authenticated()
        );
        http.addFilterBefore(new MySecurityFilter(), UsernamePasswordAuthenticationFilter.class);
       return http.build();
    }


}
