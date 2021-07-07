package edu.imi.ir.eduimiws.models.dto.mainparts;

import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCodeApiDto implements Serializable {


    private static final long serialVersionUID = -8837872266418737749L;

    private Long id;

    private String paymentCodePublicId;

    private String paymentCode;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private Long requestId;

    private PersonDto creator;
    private String creatorPublicId;
    private Long creatorId;

    private String description;

    private String requestIp;

    private String requestDescription;

    private String nationalCode;

    private ExpenseCodeApiDto expenseCodeApi;
    private String expenseCodePublicId;
    private Long expenseCodeId;

    private Long expenseCode;

    private ProjectDto project;
    private String projectPublicId;
    private Long projectId;

    private String projectCode;

    private Long bankId;

    private String bankCode;

    private Long requestCode;

    private PersonDto person;
    private String personPublicId;
    private Long personId;

    private ContactDto contact;
    private String contactPublicId;
    private Long contactId;

}
