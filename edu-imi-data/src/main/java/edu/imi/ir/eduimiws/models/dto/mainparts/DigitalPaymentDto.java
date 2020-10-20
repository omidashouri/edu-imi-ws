package edu.imi.ir.eduimiws.models.dto.mainparts;

import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DigitalPaymentDto implements Serializable {

    private static final long serialVersionUID = -3047420087860964068L;

    private Long id;

    private Long amount;

    private Long resnum;

    private String mid;

    private String sectionName;

    private Long sectionId;

    private String refnum;

    private String state;

    private String bank;

    private String firstName;

    private String lastName;

    private String pdate;

    private String ptime;

    private String fstate;


    private ContactDto contactDto;
    private String contactPublicId;
    private Long contactId;

    private CompanyDto companyDto;
    private String companyPublicId;
    private Long companyId;

    private PersonDto personDto;
    private String personPublicId;
    private Long personId;

    private Long wage;

    private Long discount;

    private String srefid;

    private String hasSanad;

    private DigitalPaymentApiDto digitalPaymentApiDto;
    private String digitalPaymentPublicId;
    private Long digitalPaymentApiId;
}
