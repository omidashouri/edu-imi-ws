package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryDto implements Serializable {

    private static final long serialVersionUID = -1087830956446836356L;

    private Long id;

    private String courseCategoryPublicId;

    private String title;

    private CourseCategoryDto parentDto;

    private CompanyDto companyDto;

    private Long companyId;

    private String companyPublicId;

    private PersonDto creatorDto;

    private String creatorPublicId;

    private Long creatorId;

    private String createDate;

    private PersonEntity editorDto;

    private String editorPublicId;

    private Long editorId;

    private String editDate;

    private CourseCategoryApiDto courseCategoryApiDto;

    private Long courseCategoryApiId;
}
