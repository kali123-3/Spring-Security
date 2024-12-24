package com.example.Spring.Security.config.security.services;

import com.example.Spring.Security.config.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Spring.Security.config.security.model.User;
import java.util.Collection;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.example.Spring.Security.config.security.model.User user = userRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities(user));
    }

    //User class we create
    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}


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
