package edu.imi.ir.eduimiws.models.response.edu;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;



@Schema(name = "periods",description = "Class representing a period in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "period")
@Relation(collectionRelation = "periods")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodResponse extends RepresentationModel<PeriodResponse> {

    @Schema(title = "Period Public ID",maxLength = 36)
    private String periodPublicId;

    @Schema(title = "Period name", maxLength = 500)
    private String name;

    @Schema(title = "Period start date",maxLength = 10)
    private String startDate;

    @Schema(title = "Period End Date",maxLength = 10)
    private String endDate;

    @Schema(title = "Period Type", maxLength = 10,
    allowableValues = {"NonTermic", "Termic"})
    private String type;

    @Schema(title = "Period Fee", type = "number")
    private Long fee;

    @Schema(title = "Period Offer Number", type = "number")
    private Long offerNumber;

    @Schema(title = "Period Create Date",maxLength = 10)
    private String createDate;

    @Schema(title = "Period Edit Date")
    private String editDate;

    @Schema(title = "Period Activity Status",
            description = "0:inactive 1:active 2:canceled 3:stopped 4:finished 5:archived ", type = "number", maxLength = 1,
    allowableValues = {"1", "2", "3", "4", "5"})
    private Long activityStatus;

    @Schema(title = "Period Delete Status", type = "number" , maxLength = 1)
    private Long deleteStatus;

    @Schema(title = "Period Maximum Capacity",type = "number",maxLength = 3)
    private Long maxCapacity;

    @Schema(title = "Period Minimum Capacity",type = "number",maxLength = 3)
    private Long minCapacity;

    @Schema(title = "Period Executor Public ID")
    private String executorPublicId;

    @Schema(title = "Period Registration Start Date",maxLength = 10)
    private String regStartDate;

    @Schema(title = "Period Registration End Date",maxLength = 10)
    private String regEndDate;

    @Schema(title = "Period Description",maxLength = 4000)
    private String description;

    @Schema(title = "Period Register OnLine Status", maxLength = 15,
    description = "noWay:can not register online periods ," +
            " preRegister:can have pre register for online periods ," +
            " register:can register online periods ",
    allowableValues = {"preRegister","register","noWay"})
    private String canRegisterOnline;

    @Schema(title = "Period Holding Type", maxLength = 20,
    description = "description will be added later",
    allowableValues = {"majazi","virtual hozori", "presence","hozori"})
    private String holdingType;

    @Schema(title = "Period Language Type", maxLength = 2,
    description = "F:Persian & E:English",
    allowableValues = {"F","E"})
    private String holdingLanguage;


}
