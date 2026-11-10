package edu.imi.ir.eduimiws.models.response.crm.farapayamak;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.response.v2.BaseResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "farapayamaks")
@Schema(name = "sendSmsCreateResponseForFarapayamak",
        description = "Send SMS create response (logged POST)")
@JsonRootName(value = "sendSmsResponseForFarapayamak")
@Relation(collectionRelation = "sendSmsResponseForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class SendSmsCreateResponseForFarapayamak extends BaseResponseDto {

    @Schema(title = "values")
    @JsonProperty("values")
    private List<String> values = new ArrayList<>();

    @Schema(title = "return_statuses")
    @JsonProperty("return_statuses")
    private List<String> retStatuses = new ArrayList<>();

    @Schema(title = "string_return_statuses")
    @JsonProperty("string_return_statuses")
    private List<String> strRetStatuses = new ArrayList<>();
}
