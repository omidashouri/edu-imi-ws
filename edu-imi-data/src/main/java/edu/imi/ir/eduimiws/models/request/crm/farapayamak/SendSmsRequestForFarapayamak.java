package edu.imi.ir.eduimiws.models.request.crm.farapayamak;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "farapayamaks")
@Schema(name = "sendSmsRequestForFarapayamak", description = "Class representing a send sms from farapayamak in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "sendSmsRequestForFarapayamak")
@Relation(collectionRelation = "sendSmsRequestForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendSmsRequestForFarapayamak extends RepresentationModel<SendSmsRequestForFarapayamak> {


    @Schema(title = "mobile_numbers", maxLength = 20)
    @JsonProperty("mobile_numbers")
    private List<String> mobileNumbers = new ArrayList<>();

    @Schema(title = "message_text", maxLength = 100)
    @JsonProperty("message_text")
    private String messageText;


    @Schema(title = "is_message_flash", maxLength = 1)
    @JsonProperty("is_message_flash")
    private Boolean isMessageFlash;

}
