package edu.imi.ir.eduimiws.models.response.edu;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Column;

//___periodfour
@Schema(name = "periodProjectionCustomFour",description = "Class representing a period in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "periodProjectionCustomFour")
@Relation(collectionRelation = "periodProjectionCustomFours")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodResponseCustomFour {

    @Schema(title = "Period Public Id", maxLength = 36)
    private String periodPublicId;

    @Schema(title = "Field Public ID", maxLength = 36)
    private String fieldPublicId;

    @Schema(title = "Education Category Public ID", maxLength = 36)
    private String eduCategoryPublicId;

    @Schema(title = "Level Public ID", maxLength = 36)
    private String levelPublicId;

    @Column(name = "PROJECT_PUBLIC_ID", length = 500)
    private String projectPublicId;

    @Schema(title = "Project Deposit Code Api Public Id", maxLength = 36)
    private String publicId;

    @Schema(title = "Field Code (marja)", maxLength = 20)
    private String code;

    @Schema(title = "Deposit Code", maxLength = 30)
    private String depositCode;

    @Schema(title = "Project Code", maxLength =30 )
    private String projectCode;

    @Schema(title = "Offer Number (nobat)",type = "number")
    private Long offerNumber;

    @Schema(title = "Field Persian Name", maxLength = 500)
    private String fieldName;

    @Schema(title = "Period Name", maxLength = 500)
    private String name;

    @Schema(title = "Project Name", maxLength =500 )
    private String projectName;

    @Schema(title = "Education Category Title", maxLength = 100)
    private String eduCategoryTitle;

    @Schema(title = "Period start date", maxLength = 10)
    private String startDate;

    @Schema(title = "Period End Date", maxLength = 10)
    private String endDate;

    @Schema(title = "Period Registration Start Date",maxLength = 10)
    private String regStartDate;

    @Schema(title = "Period Registration End Date",maxLength = 10)
    private String regEndDate;

    @Schema(title = "Period Maximum Capacity",type = "number",maxLength = 3)
    private Long maxCapacity;

    @Schema(title = "Period Holding Type", maxLength = 20,
            description = "description will be added later",
            allowableValues = {"majazi","virtual hozori", "presence","hozori"})
    private String holdingType;

    @Schema(title = "Period Register OnLine Status", maxLength = 15,
            description = "noWay:can not register online periods ," +
                    " preRegister:can have pre register for online periods ," +
                    " register:can register online periods ",
            allowableValues = {"preRegister","register","noWay"})
    private String canRegisterOnline;

    @Schema(title = "Period Type", maxLength = 10,
            allowableValues = {"NonTermic", "Termic"})
    private String type;

    @Schema(title = "Period Fee", type = "number")
    private Long fee;

    @Schema(title = "Period Schedule",maxLength = 250)
    private String schedule;

    @Schema(title = "Period Activity Status",
            description = "0:inactive 1:active 2:canceled 3:stopped 4:finished 5:archived ",
            type = "number", maxLength = 1, allowableValues = {"1", "2", "3", "4", "5"})
    private Long activityStatus;

    @Schema(title = "Period Delete Status", type = "number" , maxLength = 1)
    private Long deleteStatus;

    @Schema(title = "Period Total Unit", type = "number")
    private Long totalUnit;

    @Schema(title = "Period Id", type = "number")
    private Long periodId;

    @Schema(title = "Period Executor First Name" , maxLength = 100)
    private String executorFirstName;

    @Schema(title = "Period Executor Last Name", maxLength = 100)
    private String executorLastName;


    private Long planId;

   // @Schema(title = "Period Executor Full Name", maxLength = 200)
   // private String executorFullName;

    //  @Schema(title = "Period Discount", type = "number")
    // private Long periodDiscount;

     @Schema(title = "Period Discount Fee", type = "number")
    private Double periodDiscountFee;

    //  @Schema(title = "Level Title Name", maxLength = 50)
    //  private String levelTitle;

}
