package com.reportme.service.person;

import com.reportme.exception.person.UsernameNotAvailableException;
import com.reportme.model.person.Person;
import com.reportme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("personService")
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) throws UsernameNotAvailableException {
        if(isUsernameAvailable(person.getPersonData().getUsername())){
            return personRepository.save(person);
        }
        throw new UsernameNotAvailableException("Username is not available. Choose another one.");
    }

    private boolean isUsernameAvailable(final String username) {
        return !personRepository.findByPersonDataUsername(username).isPresent();
    }

    public Optional<Person> findByUsername(final String username) {
        return personRepository.findByPersonDataUsername(username);
    }
}
