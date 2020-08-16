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
public class CourseDto implements Serializable {

    private static final long serialVersionUID = -2766665200663997984L;


    private Long id;

    private String coursePublicId;

    private String code;

    private String fname;

    private String lname;

    private Long tunit;

    private Long activityStatus;

    private String creatorpublicId;

    private Long creatorId;

    private PersonDto creatorDto;

    private String createDate;

    private String editorPublicId;

    private Long editorId;

    private PersonDto editorDto;

    private String editDate;

    private String companyPublicId;

    private Long companyId;

    private CompanyDto companyDto;

    private Long deleteStatus;

    private String description;

    private Long courseTypeId;

    private Long ctime;

    private CourseCategoryDto courseCategoryDto;

    private Long courseCategoryId;

    private String courseCategoryPublicId;

    private String silabesFile;

    private String silabes;

    private String courseAim;

    private String courseRef;

    private String levelPublicId;

    private Long levelId;

    private LevelDto levelDto;

    private Long courseApiId;

    private CourseApiDto courseApiDto;
}
