package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.response.v2.BaseResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "privilegeCreate", description = "Privilege create response (logged POST)")
@JsonRootName(value = "privilege")
@Relation(collectionRelation = "privileges")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PrivilegeCreateResponse extends BaseResponseDto {

    @Schema(title = "Privilege Public ID", maxLength = 36)
    private String privilegePublicId;

    @Schema(title = "Privilege Name", maxLength = 100)
    private String name;
}
