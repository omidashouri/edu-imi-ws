package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelApiEntity;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelDto implements Serializable {

    private String levelPublicId;

    private Long id;

    private String description;

    private String code;

    private CompanyEntity company;

    private Long companyId;

    private String companyPublicId;

    private String termicStatus;

    private PersonEntity creator;

    private Long creatorId;

    private String creatorPublicID;

    private PersonEntity editor;

    private Long editorId;

    private String editorPublicID;

    private String createDate;

    private String editDate;

    private String paymentType;

    private String title;

    private String certTitle;

    private LevelApiEntity levelApi;

}
