package com.reportme.service;

import com.reportme.exception.person.ConfirmationTokenException;
import com.reportme.exception.person.UsernameException;
import com.reportme.model.person.Person;
import com.reportme.service.person.ConfirmTokenPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationEmailSenderService {
    @Autowired
    private MailSender mailSender;

    @Value("${reportmeMail}")
    private String reportmeMail;
    @Value("${defaultEmailHeader}")
    private String defaultEmailHeader;
    @Value("${defaultEmailBody}")
    private String defaultEmailBody;
    @Value("${defaultConfirmationLink}")
    private String defaultConfirmationLink;

    @Autowired
    private ConfirmTokenPersonService confirmTokenPersonService;
    /**
     *
     * @param person
     * @return true if email was send or false if MailException occured
     */
    public boolean sendConfirmationEmail(Person person) throws UsernameException, ConfirmationTokenException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(reportmeMail);
        simpleMailMessage.setTo(person.getPersonData().getEmail());
        simpleMailMessage.setSubject(defaultEmailHeader);
        simpleMailMessage.setText(defaultEmailBody + "\r\n\r\n"
                + defaultConfirmationLink
                + confirmTokenPersonService.findTokenByUsername(person.getPersonData().getUsername())
                + "?username=" + person.getPersonData().getUsername()
        );

        try {
            mailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            return false;
        }
    }
}
