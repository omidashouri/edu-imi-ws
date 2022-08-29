package edu.imi.ir.eduimiws.models.request.behdad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;


@Tag(name = "behdadidentifiers")
@Schema(name = "IdentifierIsVerhoeffRequest", description = "Class representing Identifier IsVerhoeff Request ")
@JsonRootName(value = "identifierIsVerhoeffRequest")
@Relation(collectionRelation = "identifierIsVerhoeffRequests")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class IdentifierIsVerhoeffRequest {
//        extends IsVerhoeffRequest {
}
