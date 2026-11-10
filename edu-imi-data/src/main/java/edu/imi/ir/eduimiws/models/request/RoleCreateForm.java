package edu.imi.ir.eduimiws.models.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.request.v2.BaseRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Schema(name = "roleCreate", description = "Create role in application (logged POST)")
@JsonRootName(value = "role")
@Relation(collectionRelation = "roles")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RoleCreateForm extends BaseRequestDto {

    @Schema(title = "Role Name", maxLength = 20)
    private String roleName;

    @Schema(title = "Privilege Public Name", maxLength = 36)
    private List<String> privilegePublicId;
}
