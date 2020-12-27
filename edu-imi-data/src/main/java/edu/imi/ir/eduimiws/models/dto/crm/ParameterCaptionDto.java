package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParameterCaptionDto implements Serializable {

    private static final long serialVersionUID = -3497378249260440046L;

    private Long id;

    private ParameterDto parameterId;

    private String caption;

    private LanguageDto languageId;
}
