package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryApiEntity;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EduCategoryDto implements Serializable {

    private static final long serialVersionUID = -6961823590476763575L;

    private String title;

    private EduCategoryEntity parent;

    private CompanyEntity company;

    private Long companyId;

    private PersonEntity editor;

    private PersonEntity creator;

    private EduCategoryApiEntity eduCategoryApi;
}
