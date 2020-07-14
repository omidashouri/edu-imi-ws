package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelDto implements Serializable {

    private String levelPublicId;

    private String description;

    private String code;

    private CompanyEntity company;

    private String termicStatus;

    private PersonEntity creator;

    private PersonEntity editor;

    private String createDate;

    private String editDate;

    private String paymentType;

    private String title;

    private String certTitle;

}
