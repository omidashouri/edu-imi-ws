package edu.imi.ir.eduimiws.models.response.crm;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Collection;

@Schema(name = "users", description = "Class representing a user in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "user")
@Relation(collectionRelation = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePrivilegeResponse extends RepresentationModel<UserRolePrivilegeResponse> {

    @Schema(title = "Person Public ID",maxLength = 36)
    private String personPublicId;

    @Schema(title = "Contact Public ID",maxLength = 36)
    private String contactPublicId;

    @Schema(title = "First Name", maxLength = 100)
    private String firstName;

    @Schema(title = "Last Name", maxLength = 100)
    private String lastName;

    @Schema(title = "Last Name", maxLength = 20)
    private String nationCode;

    @Schema(title = "USERNAME", maxLength = 100)
    private String username;

    @Schema(title = "User Roles" )
    private Collection<RoleResponse> roleResponses;

}
