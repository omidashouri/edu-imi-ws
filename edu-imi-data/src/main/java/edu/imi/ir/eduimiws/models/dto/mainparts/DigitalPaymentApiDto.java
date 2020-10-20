package edu.imi.ir.eduimiws.models.dto.mainparts;

import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DigitalPaymentApiDto implements Serializable {

    private static final long serialVersionUID = 4199191682619085626L;

    private Long id;

    private DigitalPaymentDto digitalPaymentDto;
    private Long digitalPaymentId;

    private String digitalPaymentPublicId;

    private Long deletedDigitalPaymentId;

    private ContactDto contactDto;
    private Long contactId;


    private String contactPublicId;

    private CompanyDto companyDto;
    private Long companyId;

    private String companyPublicId;

    private PersonDto personDto;
    private Long personId;

    private String personPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

}
