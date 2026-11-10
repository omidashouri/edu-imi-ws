package edu.imi.ir.eduimiws.models.request.crm.farapayamak;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.request.v2.BaseRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "farapayamaks")
@Schema(name = "sendSmsRequestForFarapayamak", description = "Class representing a send sms from farapayamak in the application.")
@EqualsAndHashCode(callSuper = true)
@JsonRootName(value = "sendSmsRequestForFarapayamak")
@Relation(collectionRelation = "sendSmsRequestForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class SendSmsRequestForFarapayamak extends BaseRequestDto {

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
