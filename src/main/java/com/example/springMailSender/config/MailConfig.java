package com.example.springMailSender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;

    @Value("${mail.properties.mail.transport.protocol}")
    private String protocol;

    @Value("${mail.properties.mail.debug}")
    private String debug;

    @Value("${mail.properties.mail.smtp.auth}")
    private String auth;

    @Value("${mail.properties.mail.smtp.starttls.enable}")
    private String enable;


    @Bean
    public JavaMailSender getMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();

        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug", debug);
        properties.setProperty("mail.smtp.auth", auth);
        properties.setProperty("mail.smtp.starttls.enable", enable);

        return mailSender;
    }
}
