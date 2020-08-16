package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto implements Serializable {

    private static final long serialVersionUID = 1625681621446262691L;

    private String registerPublicId;

    private Long periodId;

    private String periodPublicId;

    private Long studentId;

    private String studentPublicId;

    private String periodName;

    private String studentFirstName;

    private String studentLastName;

    private String studentFullName;

    private Long activityStatus;

    private Long deleteStatus;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private Long financialStatus;

    private String registerType;

    private Long fee;

    private Long periodContractId;

    private String statusDate;

    private String accountPublicId;

    private Long contractId;

    private String registerDate;

    private Long paidFee;

    private Long discount;

    private Long totalPaid;

    private Long finalScore;

    private String finalStatus;

    private String financialDesc;

    private String registerFrom;

    private String fileNewName;

    private String fileOldName;

    private String cardNo;

    private String educationType;

    private String attachDate;

    private String hasSanad;

    private String tempScore;

    private String tempTime;

    private Long termFee;

    private String tempDate;

    private String financialStatusDate;

    private String financialPersonPublicId;

    private String fromRegisterPublicId;
}
