package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermFastDto {

    private String termPublicId;

    private String termName;

    private String startDate;

    private String endDate;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private String companyPublicId;

    private String regStartDate;

    private String regEndDate;

    private String year;

    private Long currentTerm;

    private String type;

}
