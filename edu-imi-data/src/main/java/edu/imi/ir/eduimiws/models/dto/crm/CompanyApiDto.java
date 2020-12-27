package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyApiDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private CompanyDto company;
    private Long companyId;

    private String companyPublicId;

    private Long deletedCompanyId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

}
