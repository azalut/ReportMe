package com.reportme.service.person;

import com.reportme.model.person.Person;
import com.reportme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findByUsername(final String username) {
        return personRepository.findByPersonDataUsername(username);
    }

}
