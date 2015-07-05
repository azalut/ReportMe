package com.reportme.service.person;

import com.reportme.model.person.Person;
import com.reportme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) {
        return null;
    }
}
