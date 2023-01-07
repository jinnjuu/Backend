package com.alevel.backend.service;

import com.alevel.backend.domain.user.Certified;
import com.alevel.backend.domain.user.CertifiedRepository;
import com.alevel.backend.exception.InvalidateTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final CertifiedRepository certifiedRepository;

    @Autowired
    public MailService(
            CertifiedRepository certifiedRepository,
            JavaMailSender mailSender
    ) {
        this.certifiedRepository = certifiedRepository;
        this.mailSender = mailSender;
    }

    public int createKey() {
        Random random = new Random();
        return random.nextInt(888888)+111111;
    }

    public boolean sendMail(String to) {

        final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;
        boolean success = false;

        int key = createKey();
        certifiedRepository.save(
                new Certified(
                        to,
                        Integer.toString(key),
                        LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE)
                )
        );
        String subject = "[한잔할래] 회원가입 인증 메일입니다.";
        String content = "인증번호 : " + key + "<br>";

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

    public Certified confirmToken(String email, String token) {
        Certified certified =
                certifiedRepository.findTop1ByEmailAndTokenAndExpirationDateAfterAndExpiredOrderByExpirationDateDesc(
                    email,
                    token,
                    LocalDateTime.now(),
                    false
            ).orElseThrow(()-> new InvalidateTokenException());

        certified.useToken();
        certified.verifiedSuccess();
        return certifiedRepository.save(certified);
    }
}
