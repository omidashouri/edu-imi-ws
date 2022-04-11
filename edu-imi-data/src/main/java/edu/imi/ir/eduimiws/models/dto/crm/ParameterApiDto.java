package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParameterApiDto {


    private Long id;

    private Long parameterId;
    private ParameterDto parameterDto;

    private String parameterPublicId;

    private Long deletedParameterId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;
}
