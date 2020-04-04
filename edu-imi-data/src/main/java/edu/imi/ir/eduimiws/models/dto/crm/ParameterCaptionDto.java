package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterCaptionDto implements Serializable {

    private static final long serialVersionUID = -3497378249260440046L;

    private ParameterDto parameterId;

    private String caption;

    private LanguageDto languageId;
}
