package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.response.v2.BaseResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "userCreate", description = "User register response (logged POST)")
@JsonRootName(value = "user")
@Relation(collectionRelation = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UserCreateResponse extends BaseResponseDto {

    @Schema(title = "Person Public ID", maxLength = 36)
    private String personPublicId;

    @Schema(title = "Contact Public ID", maxLength = 36)
    private String contactPublicId;

    @Schema(title = "First Name", maxLength = 100)
    private String firstName;

    @Schema(title = "Last Name", maxLength = 100)
    private String lastName;

    @Schema(title = "National Code", maxLength = 20)
    private String nationCode;

    @Schema(title = "User Telephone", maxLength = 50)
    private String tel;

    @Schema(title = "User Address", maxLength = 1000)
    private String address;

    @Schema(title = "User Email", maxLength = 100)
    private String email;

    @Schema(title = "USERNAME", maxLength = 100)
    private String username;
}
