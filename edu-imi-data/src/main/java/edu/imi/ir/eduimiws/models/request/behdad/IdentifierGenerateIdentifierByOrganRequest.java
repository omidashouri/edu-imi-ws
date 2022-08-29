package edu.imi.ir.eduimiws.models.request.behdad;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Tag(name = "behdadidentifiers")
@Schema(name = "IdentifierGenerateIdentifierByOrganRequest",
        description = "Class representing Identifier Generate Identifier By Organ Request ")
@JsonRootName(value = "identifierGenerateIdentifierByOrganRequest")
@Relation(collectionRelation = "identifierGenerateIdentifierByOrganRequests")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class IdentifierGenerateIdentifierByOrganRequest {
//        extends GenerateIdentifierByOrganRequest {
}
