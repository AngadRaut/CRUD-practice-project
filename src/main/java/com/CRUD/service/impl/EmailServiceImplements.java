package com.CRUD.service.impl;

import com.CRUD.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplements implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    @Override
    public void sendEmployeeWelcomeEmail(String toEmail, String name) {
        try {
            System.out.println("EMAIL SERVICE CALLED for: " + toEmail);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Welcome to TEKUP SKILL");
            message.setText(
                    "Hello " + name + ",\n\n" +
                            "Welcome to TekUp Skill..!\n" +
                            "Your as student, account has been created successfully.\n\n" +
                            "Best Regards,\nTEKUP SKILL"
            );
            mailSender.send(message);
            System.out.println("EMAIL SENT SUCCESSFULLY");
        } catch (Exception e) {
            System.out.println("EMAIL FAILED: " + e.getMessage());
        }
    }
}