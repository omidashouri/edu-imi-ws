package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.models.request.EmailForm;
import edu.imi.ir.eduimiws.services.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mails")
@RequiredArgsConstructor
@Tag(name = "Mails", description = "The email API")
public class EmailController {

    private final EmailService emailService;

    @PostMapping(path = "/imi/new",
            consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PreAuthorize("hasAuthority('API_V1_CRM_EMAIL_SEND')")
    public String sendEmailFromImi(@RequestBody EmailForm emailForm) {

        List<String> emailReceivers = emailForm.getToEmails();
        String mailSubject = emailForm.getSubject();
        String mailMessage = emailForm.getMessage();

        try {
            emailService.sendMail(emailReceivers,mailSubject,mailMessage);
            return "{\"message\": \"OK\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"message\": \"Error\"}";
        }
    }
}
