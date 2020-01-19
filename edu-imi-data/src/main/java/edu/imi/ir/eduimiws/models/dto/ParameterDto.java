package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDto implements Serializable {

    private static final long serialVersionUID = 1340959888204468099L;

    private String paramName;

    private String paramValue;

    private ParameterDto mainParamId;
}
