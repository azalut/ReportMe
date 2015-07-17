package com.reportme.service.person;

import com.reportme.exception.person.ConfirmationTokenException;
import com.reportme.exception.person.UsernameException;
import com.reportme.model.person.Person;
import com.reportme.model.person.Role;
import com.reportme.repository.PersonRepository;
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
    private ConfirmTokenPersonService confirmTokenPersonService;

    public Optional<Person> create(Person person) {
        if(isUsernameAvailable(person.getPersonData().getUsername())){
            String md5password = DigestUtils.md5DigestAsHex(person.getPersonData().getPassword().getBytes());
            person.getPersonData().setPassword(md5password);

            person.getRoleSet().add(Role.ROLE_OCCUPANT);
            // persisting randomly generated token for newly created user
            confirmTokenPersonService.createToken(person);
            return Optional.of(personRepository.save(person));
        }
        return Optional.empty();
    }

    private boolean isUsernameAvailable(final String username) {
        return !personRepository.findByPersonDataUsername(username).isPresent();
    }

    public Optional<Person> findByUsername(final String username) {
        return personRepository.findByPersonDataUsername(username);
    }

    public void enableUser(String confirmationToken, String username) throws UsernameException, ConfirmationTokenException {
        if(confirmationToken.equals(confirmTokenPersonService.findTokenByUsername(username))) {
            findByUsername(username).get().getPersonData().setEnabled(true);
            confirmTokenPersonService.deleteRowByToken(confirmationToken);
        }else{
            throw new ConfirmationTokenException("Confirmation token or username was invalid");
        }
    }
}
