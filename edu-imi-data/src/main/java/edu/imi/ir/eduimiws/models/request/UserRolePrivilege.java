package edu.imi.ir.eduimiws.models.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "users",description = "User Role in application")
@JsonRootName(value = "user")
@Relation(collectionRelation = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePrivilege {

    @Schema(title = "User Role Name")
    private String roleName;

    @Schema(title = "User Privilege Name")
    private String privilegeName;

}
