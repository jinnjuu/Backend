package com.alevel.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public int createKey() {
        Random random = new Random();
        return random.nextInt(888888)+111111;
    }

    public boolean sendMail(String to, String subject, String content) {

        boolean success = false;

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(message, true, "UTF-8");

            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);

            mailSender.send(message);
            success = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return success;
    }
}
