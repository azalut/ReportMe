package com.reportme.config;

import com.reportme.model.person.Person;
import com.reportme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> personOptional = personRepository.findByUsername(s);
        if(personOptional.isPresent()){
            Person person = personOptional.get();
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
        } else {
            throw new UsernameNotFoundException("username not found");
        }

    }
}
