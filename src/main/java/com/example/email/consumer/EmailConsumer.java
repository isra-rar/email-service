package com.example.email.consumer;

import com.example.email.DTO.EmailDTO;
import com.example.email.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "${topic.name.email}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "emailKafkaListenerContainerFactory")
    public void listenTopicEmail(ConsumerRecord<String, EmailDTO> record) throws EmailException {
        EmailDTO email = record.value();
        emailService.sendEmail(email.getTo(), email.getSubject(), email.getBody());
    }
}
