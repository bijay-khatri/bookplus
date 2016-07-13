package org.group5.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Neha on 7/12/2016.
 */
@RestController
public class MailSubmissionController {

    private final JavaMailSender javaMailSender;

    @Autowired
    MailSubmissionController(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;

    }

    @RequestMapping("/mail")
    @ResponseStatus(HttpStatus.CREATED)
    public SimpleMailMessage send(SimpleMailMessage mailMessage) {
        mailMessage.setTo("orion.mengistu@gmail.com");
        mailMessage.setFrom("bansalneha2104-facilitator@gmail.com");
        mailMessage.setSubject("Confirmation Email");
        javaMailSender.send(mailMessage);
        return mailMessage;
    }


}


