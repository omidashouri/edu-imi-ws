package edu.imi.ir.eduimiws.models.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "role user",description = "create role in application")
@JsonRootName(value = "role")
@Relation(collectionRelation = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleForm {

    @Schema(title = "Role Name", maxLength = 20)
    private String name;
}
