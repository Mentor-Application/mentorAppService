package com.ssn.mentorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailsender;

    public void sendsimpleEmail(String tomail,String subject,String body) {

        SimpleMailMessage mailmessage = new SimpleMailMessage();

        mailmessage.setFrom("vigneshviki1005@gmail.com");
        mailmessage.setTo(tomail);
        mailmessage.setText(body);
        mailmessage.setSubject(subject);

        mailsender.send(mailmessage);

        System.out.println("Mail sent");
    }


}