package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto implements Serializable {

    private static final long serialVersionUID = -7485174257915256259L;

    private String nameEn;

    private String nameLo;

    private String direction;

    private String flagNewName;

    private String flagOldName;

    private String encoding;
}
