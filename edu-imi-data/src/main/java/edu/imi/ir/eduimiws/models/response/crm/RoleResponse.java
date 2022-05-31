package edu.imi.ir.eduimiws.models.response.crm;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Set;

@Schema(name = "roles", description = "Class representing a role in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "role")
@Relation(collectionRelation = "roles")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse extends RepresentationModel<RoleResponse> {

    @Schema(title = "Person Public ID",maxLength = 36)
    private String rolePublicId;

    @Schema(title = "Role Name",maxLength = 100)
    private String name;

    @Schema(title = "Privileges")
    private Set<PrivilegeResponse> privilegeResponses;

}
