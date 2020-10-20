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
public class CostTypeDto implements Serializable {

    private static final long serialVersionUID = 8094100913942912627L;

    private Long id;

    private String title;

    private Long cvalue;

    private String type;

    private CompanyDto companyDto;
    private Long companyId;
    private String companyPublicId;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String createDate;

    private String editDate;

    private String activityStatus;

    private Long cashAmount;

    private String changeable;

    private CostTypeApiDto costTypeApiDto;
    private Long costTypeId;
    private String costTypePublicId;
}
