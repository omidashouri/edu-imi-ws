package edu.imi.ir.eduimiws.servces;

import org.springframework.core.io.InputStreamSource;

import jakarta.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface EmailService {

   void sendMail(List<String> toEmails, String mailSubject, String mailMessage);

   void sendMailWithAttachment(List<String> toEmails, String subject, String message,
                               String attachmentName, InputStreamSource attachment)
           throws MessagingException, IOException;


}
