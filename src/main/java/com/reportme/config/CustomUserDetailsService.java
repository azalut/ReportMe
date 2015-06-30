package com.reportme.config;

import com.reportme.model.Person;
import com.reportme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(s);
        Set<SimpleGrantedAuthority> authoritySet = person.getRoleSet().stream().map(
                p -> new SimpleGrantedAuthority(p.getRoleString())
        ).collect(Collectors.toSet());

        return new User(
                person.getUsername(),
                person.getPassword(),
                person.isEnabled(),
                person.isEnabled(),
                person.isEnabled(),
                person.isEnabled(),
                authoritySet
        );
    }
}
