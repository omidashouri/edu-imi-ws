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
@Schema(name = "IdentifierResultResponse", description = "Class representing Identifier Result Response")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "identifierResultResponse")
@Relation(collectionRelation = "identifierResultResponses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class IdentifierResultResponse {
//        extends IdentifierResult {
}
