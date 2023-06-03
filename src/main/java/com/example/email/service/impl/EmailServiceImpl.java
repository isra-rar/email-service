package com.example.email.service.impl;

import com.example.email.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${authentication.username.simpleEmail}")
    private String emailFrom;

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private ApplicationContext context;

    @Override
    public void sendEmail(String to, String subject, String body) throws EmailException {
        try {
            SimpleEmail simpleEmail = context.getBean(SimpleEmail.class);
            simpleEmail.setFrom(emailFrom);
            simpleEmail.setSubject(subject);
            simpleEmail.setMsg(body);
            simpleEmail.addTo(to);
            simpleEmail.send();
            logger.info("E-mail foi enviado com sucesso");
        } catch (EmailException e) {
            throw new EmailException(e + "Erro ao enviar e-mail");
        }
    }
}
