package com.example.email.config;

import org.apache.commons.mail.SimpleEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public SimpleEmail simpleEmail() {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp-mail.outlook.com");
        email.setAuthentication("israel_uni@hotmail.com", "I$rael12");
        email.setSmtpPort(587);
        email.setStartTLSRequired(true);
        return email;
    }
}
