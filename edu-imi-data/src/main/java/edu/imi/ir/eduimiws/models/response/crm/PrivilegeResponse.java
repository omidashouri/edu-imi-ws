package edu.imi.ir.eduimiws.models.response.crm;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "privileges", description = "Class representing a privileges in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "privilege")
@Relation(collectionRelation = "privileges")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeResponse extends RepresentationModel<RoleResponse> {

    @Schema(title = "Person Public ID",maxLength = 36)
    private String privilegePublicId;

    @Schema(title = "Privilege Name",maxLength = 100)
    private String name;
}
