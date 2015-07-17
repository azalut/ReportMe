package com.reportme.service.person;

import com.reportme.exception.person.ConfirmationTokenException;
import com.reportme.exception.person.UsernameException;
import com.reportme.model.person.ConfirmTokenPerson;
import com.reportme.model.person.Person;
import com.reportme.repository.ConfirmTokenPersonRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ConfirmTokenPersonService {
    @Autowired
    private ConfirmTokenPersonRepository confirmTokenPersonRepository;
    @Autowired
    private PersonService personService;

    /**
     * persists randomly generated token for specified person instance
     * @param person person that needs a token
     */
    public void createToken(Person person) {
        ConfirmTokenPerson confirmTokenPerson = new ConfirmTokenPerson(RandomStringUtils.randomAlphabetic(20), person);
        confirmTokenPersonRepository.save(confirmTokenPerson);
    }

    public String findTokenByUsername(final String username) throws UsernameException, ConfirmationTokenException {
        Optional<Person> personOptional = personService.findByUsername(username);
        if(personOptional.isPresent()) {
            int personId = personOptional.get().getId();
            Optional<ConfirmTokenPerson> optionalCTP = confirmTokenPersonRepository.findByPersonId(personId);
            if(optionalCTP.isPresent()){
                return optionalCTP.get().getToken();
            }else{
                throw new ConfirmationTokenException("Person was found properly by username, but there is no row in confirmtokenperson table with the personId of: ( " + personId + " )");
            }
        }else{
            throw new UsernameException("ConfirmTokenPersonService - Username not found");
        }
    }

    /**
     * method used to remove record from table after account activation
     * @param token
     */
    public void deleteRowByToken(final String token) {
        confirmTokenPersonRepository.delete(confirmTokenPersonRepository.findByToken(token));
    }
}
