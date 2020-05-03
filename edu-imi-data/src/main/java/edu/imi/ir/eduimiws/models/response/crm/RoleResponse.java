package edu.imi.ir.eduimiws.models.response.crm;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Schema(name = "roles", description = "Class representing a role in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "role")
@Relation(collectionRelation = "roles")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse extends RepresentationModel<RoleResponse> {

    private String name;
    private List<PrivilegeApiEntity> privilegeApies;

}
