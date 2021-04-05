package edu.imi.ir.eduimiws.models.dto.crm;


import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountApiDto implements Serializable {

    private Long id;

    private AccountDto account;
    private Long accountId;
    private String accountPublicId;

    private Long deletedAccountId;

    private CompanyDto company;
    private Long companyId;
    private String companyPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

}
