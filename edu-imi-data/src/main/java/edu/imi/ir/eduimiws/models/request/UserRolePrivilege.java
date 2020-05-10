package edu.imi.ir.eduimiws.models.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Schema(name = "Role User",description = "User Role in application")
@JsonRootName(value = "role")
@Relation(collectionRelation = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePrivilege {

    @Schema(title = "User Role public Ids")
    private List<String> rolePublicId;

/*    @Schema(title = "User Privilege Name")
    private String privilegeName;*/

}
