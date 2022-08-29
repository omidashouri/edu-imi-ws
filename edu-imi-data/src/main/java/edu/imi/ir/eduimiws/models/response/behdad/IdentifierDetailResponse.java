package edu.imi.ir.eduimiws.models.response.behdad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;


@Tag(name = "behdadidentifiers")
@Schema(name = "IdentifierDetailResponse", description = "Class representing Identifier Detail Response")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "identifierDetailResponse")
@Relation(collectionRelation = "identifierDetailResponses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class IdentifierDetailResponse {
//        extends IdentifierDetail {
}
