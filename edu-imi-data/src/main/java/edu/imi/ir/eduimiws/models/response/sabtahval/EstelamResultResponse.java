package edu.imi.ir.eduimiws.models.response.sabtahval;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
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
public class EstelamResultResponse extends RepresentationModel<EstelamResultResponse> {

    @Schema(title = "Death Date", maxLength =8 )
    private String deathDate;

    @Schema(title = "Exception Message", maxLength =50 )
    private String exceptionMessage;

    @Schema(title = "Birth Date", type = "number", example = "13611205",
            description = "include YEAR four digit, MONTH two digit, DAY two digit. with out slash")
    private Integer birthDate;

    @Schema(title = "Identification Number", maxLength =500)
    private Integer bookNo;

    @Schema(title = "Book Number", type = "number")
    private Integer bookRow;

    @Schema(title = "Death Status", type = "number",
    description = "0=Alive, 1=Dead")
    private Integer deathStatus;

    @Schema(title = "Family Name", maxLength =500)
    private String family;

    @Schema(title = "Father Name", maxLength =500)
    private String fatherName;

    @Schema(title = "Gender", type = "number",
            description = "0=Female, 1=Male")
    private Integer gender;

    @Schema(title = "Exception Message", maxLength =500, type = "array")
    private List<String> messages;

    @Schema(title = "Name", maxLength =500)
    private String name;

    @Schema(title = "Identification Number", type = "number",
    description = "code Melli", example = "0075175266")
    private Long nin;

    @Schema(title = "Office Code", type = "number")
    private Integer officeCode;

    @Schema(title = "Office Name", maxLength =500)
    private String officeName;

    @Schema(title = "Identification Num", type = "number",
            description = "shomare Shenasname", example = "5205")
    private Integer shenasnameNo;

    @Schema(title = "Identification Seri", maxLength =500, example = "۹۲ا",
    description="include text and number, for 'الف' use 'ا'" )
    private String shenasnameSeri;

    @Schema(title = "Identification Serial", type = "number")
    private Integer shenasnameSerial;
}
