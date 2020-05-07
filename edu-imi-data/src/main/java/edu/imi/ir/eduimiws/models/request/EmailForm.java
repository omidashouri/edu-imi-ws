package edu.imi.ir.eduimiws.models.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Schema(name = "email",description = "send email in application")
@JsonRootName(value = "mail")
@Relation(collectionRelation = "mails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailForm {

    @Schema(title = "Receiver Emails", maxLength = 50)
    private List<String> toEmails;

    @Schema(title = "mail Subject", maxLength = 50)
    private String subject;

    @Schema(title = "Mail Message", maxLength = 50)
    private String message;

}
