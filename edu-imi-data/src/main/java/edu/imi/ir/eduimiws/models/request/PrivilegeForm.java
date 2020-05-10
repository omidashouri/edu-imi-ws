package edu.imi.ir.eduimiws.models.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Schema(name = "privilege user",description = "create privilege in application")
@JsonRootName(value = "privilege")
@Relation(collectionRelation = "privileges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeForm {

    @Schema(title = "Privilege Name", maxLength = 20)
    private String privilegeName;

    @Schema(title = "Role Public Name", maxLength = 36)
    private List<String> rolePublicId;
}
