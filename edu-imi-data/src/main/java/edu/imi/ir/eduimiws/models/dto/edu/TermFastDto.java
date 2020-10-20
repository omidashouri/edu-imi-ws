package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermFastDto implements Serializable {

    private static final long serialVersionUID = 5788320093203619490L;

    private Long id;

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
