package edu.imi.ir.eduimiws.utilities;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Parameters(value = {
        @Parameter(
                in = ParameterIn.DEFAULT,
                name = "criteria",
                required = true,
                description = "<strong>criteria</strong> in the format mean array of PROPERTY[delimiters]VALUE. <br />" +
                        "PROPERTY are entity properties. and VALUE should not have space.<br />" +
                        "delimiters are >, <, !, : . <br />" +
                        "use COLON (:) as EQUAL between property and its value. <br />" +
                        "use COMMA (,) as AND between each criteria. <br />" +
                        "use GREATER-THAN (>) as greater-than sign for inequality between two values. <br />" +
                        "use LESS-THAN (<) as less-than sign for inequality between two values. <br />" +
                        "use exclamation mark (!) as NOT EQUAL between property and its value. <br />" +
                        "use QUOTATION (') as OR between each criteria. use it after comma and before property. <br />",
                example = "lastName:عاشوری,'firstName:امید",
                content = @Content(schema = @Schema(type = "string", example = "lastName:عاشوری,'firstName:امید"))
        )
})
public @interface QueryDslAsQueryParam {
}
