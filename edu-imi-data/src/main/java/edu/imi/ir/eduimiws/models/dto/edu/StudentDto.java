package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Serializable {

    private static final long serialVersionUID = 8852105146291631670L;

    private Long id;

    private PersonDto personDto;
    private Long personId;
    private String personPublicId;

    private String firstName;

    private String lastName;

    private String nationCode;

    private String code;

    private Long activityStatus;

    private Long deleteStatus;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String editDate;

    private String description;

    private StudentApiDto studentApiDto;
    private Long studentApiId;
    private String studentPublicId;
}
