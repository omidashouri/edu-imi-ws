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

import java.util.Set;

@Schema(name = "roleCreate", description = "Role create response (logged POST)")
@JsonRootName(value = "role")
@Relation(collectionRelation = "roles")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RoleCreateResponse extends BaseResponseDto {

    @Schema(title = "Role Public ID", maxLength = 36)
    private String rolePublicId;

    @Schema(title = "Role Name", maxLength = 100)
    private String name;

    @Schema(title = "Privileges")
    private Set<PrivilegeResponse> privilegeResponses;
}
