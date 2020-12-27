package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto implements Serializable {

    private static final long serialVersionUID = -7485174257915256259L;

    private Long id;

    private String nameEn;

    private String nameLo;

    private String direction;

    private String flagNewName;

    private String flagOldName;

    private String encoding;
}
