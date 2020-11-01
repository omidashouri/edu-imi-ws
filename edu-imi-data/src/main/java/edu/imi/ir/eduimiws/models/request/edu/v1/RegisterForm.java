package edu.imi.ir.eduimiws.models.request.edu.v1;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "register", description = "Register student in period")
@JsonRootName(value = "register")
@Relation(collectionRelation = "registers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {

    private String studentPublicId;
    private String periodPublicId;
    private String registerType;
    private String accountPublicId;
}
