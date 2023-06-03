package com.example.email.config;

import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationBeans {

    @Value("${smtp.outlook}")
    private String smtp;

    @Value("${authentication.username.simpleEmail}")
    private String username;

    @Value("${authentication.password.simpleEmail}")
    private String password;

    @Value("${authentication.smtp.port.simpleEmail}")
    private int smptPort;

    @Bean
    @Scope("prototype")
    public SimpleEmail simpleEmail() {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(smtp);
        email.setAuthentication(username, password);
        email.setSmtpPort(smptPort);
        email.setStartTLSRequired(true);
        return email;
    }
}
