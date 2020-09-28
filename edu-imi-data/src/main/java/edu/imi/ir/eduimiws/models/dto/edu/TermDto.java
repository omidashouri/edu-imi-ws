package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermDto implements Serializable {

    private static final long serialVersionUID = -2450419700271620149L;

    private String termPublicId;

    private Long id;

    private String termName;

    private String startDate;

    private String endDate;

    private PersonDto creatorDto;

    private Long creatorId;

    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;

    private Long editorId;

    private String editorPublicId;

    private String editDate;

    private CompanyDto companyDto;

    private Long companyId;

    private String companyPublicId;

    private String regStartDate;

    private String regEndDate;

    private String year;

    private Long currentTerm;

    private String type;

    private TermApiDto termApiDto;
}
