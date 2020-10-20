package edu.imi.ir.eduimiws.models.dto.mainparts;

import edu.imi.ir.eduimiws.models.dto.crm.ParameterDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefundDto implements Serializable {

    private static final long serialVersionUID = 4511300521188924457L;

    private Long id;

    private String subject;

    private String price;

    private String firstName;

    private String lastName;

    private String paymentType;

    private Long planId;

    private String reDate;

    private Long sectionId;

    private String sectionName;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String createDate;

    private String editDate;

    private ParameterDto bankDto;
    private Long bankId;
    private String bankPublicId;

    private String bankAccountOwner;

    private String bankCardNumber;

    private String toPerson;

    private String activityStatus;

    private RefundApiDto refundApiDto;
    private Long refundDtoPublicId;
    private String refundPublicId;
}
