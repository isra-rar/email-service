package com.example.email.service;

import org.apache.commons.mail.EmailException;

public interface EmailService {

    void sendEmail(String to, String subject, String body) throws EmailException;
}
