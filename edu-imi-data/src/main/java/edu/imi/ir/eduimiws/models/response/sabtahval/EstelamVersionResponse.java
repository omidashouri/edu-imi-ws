package edu.imi.ir.eduimiws.models.response.sabtahval;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "sabtahvals", description = "Class representing a sabtahval in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "sabtahval")
@Relation(collectionRelation = "sabtahvals")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstelamVersionResponse extends RepresentationModel<EstelamVersionResponse> {

    @Schema(title = "Version Number", maxLength =10 )
    private String versionNumber;
}
