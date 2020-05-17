package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;




@Schema(name = "registers",description = "Class representing a register in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "register")
@Relation(collectionRelation = "registers")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse extends RepresentationModel<RegisterResponse> {


    @Schema(title = "register Public ID",maxLength = 36)
    private String registerPublicId;

    @Schema(title = "Period Public ID",maxLength = 36)
    private String periodPublicId;

    @Schema(title = "Period Name",maxLength = 500)
    private String periodName;

    @Schema(title = "Student Public ID",maxLength = 36)
    private String studentPublicId;

    @Schema(name="Student First Name",maxLength = 100)
    private String studentFirstName;

    @Schema(name="Student Last Name",maxLength = 100)
    private String studentLastName;

    @Schema(name="Student Full Name",maxLength = 200)
    private String studentFullName;

    @Schema(title = "Student Public ID",maxLength = 2)
    private Long activityStatus;

    @Schema(title = "Delete Status",maxLength = 2)
    private Long deleteStatus;

    @Schema(title = "Creator Public ID",maxLength = 36)
    private String creatorPublicId;

    @Schema(title = "Create Date",maxLength = 10)
    private String createDate;

    @Schema(title = "Editor Public ID",maxLength = 36)
    private String editorPublicId;

    @Schema(title = "Edit Date",maxLength = 10)
    private String editDate;

    @Schema(title = "Financial Status",maxLength = 2)
    private Long financialStatus;

    @Schema(title = "Register Type",maxLength = 20)
    private String registerType;

    @Schema(title = "Fee",maxLength = 2)
    private Long fee;

    @Schema(title = "Period Contract id",type = "number")
    private Long periodContractId;

    @Schema(title = "Status Date",maxLength = 10)
    private String statusDate;

    @Schema(title = "Account public Id",maxLength = 36)
    private String accountPublicId;

    @Schema(title = "Contract Id",type = "number")
    private Long contractId;

    @Schema(title = "Register Date",maxLength = 10)
    private String registerDate;

    @Schema(title = "Paid Fee",type="number")
    private Long paidFee;

    @Schema(title = "Discount",maxLength = 20)
    private Long discount;

    @Schema(title = "Total Paid",type = "number")
    private Long totalPaid;

    @Schema(title = "Final Score",type = "number")
    private Long finalScore;

    @Schema(title = "Final Status",maxLength = 20)
    private String finalStatus;

    @Schema(title = "Financial Description",maxLength = 1000)
    private String financialDesc;

    @Schema(title = "Register From",maxLength = 20)
    private String registerFrom;

    @Schema(title = "Field New Name",maxLength = 50)
    private String fileNewName;

    @Schema(title = "File Old Name",maxLength = 50)
    private String fileOldName;

    @Schema(title = "Card Number",maxLength = 20)
    private String cardNo;

    @Schema(title = "Education Type",maxLength = 10)
    private String educationType;

    @Schema(title = "Attach Date",maxLength = 10)
    private String attachDate;

    @Schema(title = "Has Senad",maxLength = 1)
    private String hasSanad;

    @Schema(title = "Temporary Score",maxLength = 20)
    private String tempScore;

    @Schema(title = "Temporary Time",maxLength = 20)
    private String tempTime;

    @Schema(title = "Term Fee",type = "number")
    private Long termFee;

    @Schema(title = "Temporary Date",maxLength = 10)
    private String tempDate;

    @Schema(title = "Financial Status Date",maxLength = 10)
    private String financialStatusDate;

    @Schema(title = "Financial Person Public Id",maxLength = 36)
    private String financialPersonPublicId;

    @Schema(title ="From Register Public Id",maxLength = 36)
    private String fromRegisterPublicId;
}
