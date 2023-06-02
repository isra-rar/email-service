package com.example.email.service.impl;

import com.example.email.consumer.EmailConsumer;
import com.example.email.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final String EMAIL_FROM = "israel_uni@hotmail.com";
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final SimpleEmail simpleEmail;

    public EmailServiceImpl(SimpleEmail simpleEmail) {
        this.simpleEmail = simpleEmail;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        try {
            simpleEmail.setFrom(EMAIL_FROM);
            simpleEmail.setSubject(subject);
            simpleEmail.setMsg(body);
            simpleEmail.addTo(to);
            simpleEmail.send();
            logger.info("E-mail foi enviado com sucesso");
        } catch (EmailException e) {
            logger.info("Erro ao enviar e-mail");
            throw new RuntimeException(e);
        }
    }




}
