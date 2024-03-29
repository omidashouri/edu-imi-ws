package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDto implements Serializable {

    private static final long serialVersionUID = 1340959888204468099L;

    private Long id;

    private String parameterPublicId;

    private String paramName;

    private String paramValue;

    private Long mainParamId;
    private String mainParamPublicId;
    private ParameterDto mainParamDto;

    private ParameterApiDto parameterApiDto;
}
