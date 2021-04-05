package edu.imi.ir.eduimiws.models.dto.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationApiDto implements Serializable {

    private static final long serialVersionUID = 5587305048817380349L;

    private Long id;

    private OrganizationDto organization;
    private Long organizationId;
    private String organizationPublicId;

    private AccountDto account;
    private Long accountId;
    private String accountPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deletedDateTs;

    private Long deletedOrganizationId;
}
