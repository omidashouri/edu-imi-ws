package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentFastDto {

    private Long studentApiId;

    private String studentPublicId;

    private Long personId;

    private String personPublicId;

    private String firstName;

    private String lastName;

    private String nationCode;

    private String code;

    private Long activityStatus;

    private Long deleteStatus;

    private Long creatorId;

    private String creatorPublicId;

    private String createDate;

    private Long editorId;

    private String editorPublicId;

    private String editDate;

    private String description;


}