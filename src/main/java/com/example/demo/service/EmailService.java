package com.example.demo.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailService() {
    }

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @After("@annotation(SendEmail)")
    void emailCreate() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("test@test.pl");                          //add your email
        msg.setSubject("Add Film");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);

    }


}