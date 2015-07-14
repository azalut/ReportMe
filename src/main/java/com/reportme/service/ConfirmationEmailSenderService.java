package com.reportme.service;

import com.reportme.model.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Base64;

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

    /**
     *
     * @param person
     * @return true if email was send or false if MailException occured
     */
    public boolean sendConfirmationLinkEmail(Person person) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(reportmeMail);
        simpleMailMessage.setTo(person.getPersonData().getEmail());
        simpleMailMessage.setSubject(defaultEmailHeader);
        simpleMailMessage.setText(defaultEmailBody + defaultConfirmationLink + generateConfirmationToken(person) + "?username=" + person.getPersonData().getUsername());

        try {
            mailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            return false;
        }
    }

    public String generateConfirmationToken(Person person) {
        String nameLastname = person.getPersonData().getName() + person.getPersonData().getLastname();
        return Base64.getEncoder().encodeToString(nameLastname.getBytes());
    }
}
