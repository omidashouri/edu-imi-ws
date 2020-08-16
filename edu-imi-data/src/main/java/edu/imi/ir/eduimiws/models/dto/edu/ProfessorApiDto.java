package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorApiDto implements Serializable {

    private static final long serialVersionUID = 7775815718748608691L;

    private ProfessorDto professorDto;

    private Long professorId;

    private String professorPublicId;

    private PersonDto personDto;

    private Long personId;

    private String personPublicId;

    private String professorEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;
}
