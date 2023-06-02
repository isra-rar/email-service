package com.example.email.consumer;

import com.example.email.DTO.EmailDTO;
import com.example.email.service.EmailService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private static final Logger logger = LoggerFactory.getLogger(EmailConsumer.class);
    private final EmailService emailService;

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "emailKafkaListenerContainerFactory")
    public void listenTopicEmail(ConsumerRecord<String, EmailDTO> record) {
        EmailDTO email = record.value();
        emailService.sendEmail(email.getTo(), email.getSubject(), email.getBody());
    }
}
