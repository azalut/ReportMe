package com.reportme.repository;

import com.reportme.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByPersonDataUsername(String username) throws UsernameNotFoundException;
}
