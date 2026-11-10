package edu.imi.ir.eduimiws.models.request.edu.v1;

import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.request.v2.BaseRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "register", description = "Register student in period")
@JsonRootName(value = "register")
@Relation(collectionRelation = "registers")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RegisterForm extends BaseRequestDto {

    private String studentPublicId;
    private String periodPublicId;
    private String registerType;
    private String accountPublicId;
}
