package edu.imi.ir.eduimiws.models.request.sabtahval;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Schema(name = "sabtahvals", description = "Class representing a sabtahval in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "sabtahval")
@Relation(collectionRelation = "sabtahvals")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstelamPersonInfoRequest {


    @Schema(title = "Birth Date", required = true, example = "13610512",
            description = "include YEAR four digit, MONTH two digit, DAY two digit. with out slash")
    private String birthDate;

    @Schema(title = "Gender",
            description = "0=Female, 1=Male", type = "string")
    private String gender = null;

    @Schema(title = "Identification Number", required = true, example = "0075175266",
            description = "code Melli"
    )
    private String nin;

}
