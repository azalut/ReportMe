package com.reportme.service.person;

import com.reportme.exception.person.UsernameException;
import com.reportme.model.person.Person;
import com.reportme.model.person.Role;
import com.reportme.repository.PersonRepository;
import com.reportme.service.ConfirmationEmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Optional;

@Service("personService")
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ConfirmationEmailSenderService confirmationEmailSenderService;

    public Person create(Person person) throws UsernameException {
        if(isUsernameAvailable(person.getPersonData().getUsername())){
            String md5password = DigestUtils.md5DigestAsHex(person.getPersonData().getPassword().getBytes());
            person.getPersonData().setPassword(md5password);

            person.getRoleSet().add(Role.ROLE_OCCUPANT);
            return personRepository.save(person);
        }
        throw new UsernameException("Username is not available. Choose another one.");
    }

    private boolean isUsernameAvailable(final String username) {
        return !personRepository.findByPersonDataUsername(username).isPresent();
    }

    public Optional<Person> findByUsername(final String username) {
        return personRepository.findByPersonDataUsername(username);
    }

    public void enableUser(String confirmationToken, String username) throws UsernameException {
        Optional<Person> personOptional = findByUsername(username);
        if(personOptional.isPresent()){
            Person person = personOptional.get();
            String properToken = confirmationEmailSenderService.generateConfirmationToken(person);
            if(properToken.equals(confirmationToken)){
                person.getPersonData().setEnabled(true);
            }
        }else{
            throw new UsernameException("Username was not found.");
        }
    }
}
