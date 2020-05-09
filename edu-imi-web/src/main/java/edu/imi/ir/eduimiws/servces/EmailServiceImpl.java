package edu.imi.ir.eduimiws.servces;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSenderImpl javaMailSender;
    private final SimpleMailMessage simpleMailMessage;

    @Override
    public void sendMail(List<String> toEmails, String subject, String message) {

        simpleMailMessage.setFrom("edusupport@imi.ir");
        simpleMailMessage.setTo(toEmails.stream().toArray(String[]::new));
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendMailWithAttachment(List<String> toEmails, String subject, String message,
                                       String attachmentName, InputStreamSource attachment)
            throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setTo(toEmails.stream().toArray(String[]::new));
        mimeMessageHelper.setSubject(subject);
//        message = "<h1>Check attachment for image!</h1>";
        mimeMessageHelper.setText(message,true);
        mimeMessageHelper.addAttachment(attachmentName,attachment);
        javaMailSender.send(mimeMessage);
    }
}
