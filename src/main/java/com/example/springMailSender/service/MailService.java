package com.example.springMailSender.service;

import com.example.springMailSender.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender mailSender;

    @Value("${mail.username}")
    private String username;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(Message message) {
        send(message.getTo(), message.getSubject(), message.getText());
    }

    public void send(String emailTo, String subject, String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        mailSender.send(mailMessage);

    }
}
