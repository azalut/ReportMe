package com.reportme.repository;

import com.reportme.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    public Person findByUsername(String username);
}
