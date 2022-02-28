package edu.imi.ir.eduimiws.models.response.hamkaran.v1;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Schema(name = "hamkaranAuthenticationToken",description = "Hamkaran Authentication Token")
@JsonRootName(value = "hamkaranAuthenticationToken")
@Relation(collectionRelation = "hamkaranAuthenticationToken")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranAuthenticationTokenResponse implements Serializable {

    private String success;
    private String token;
    private String message;
}
