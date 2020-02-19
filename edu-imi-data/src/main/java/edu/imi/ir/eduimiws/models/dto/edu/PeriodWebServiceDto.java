package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodWebServiceDto implements Serializable {

    private static final long serialVersionUID = -3440156297947149924L;

    private PeriodDto periodDto;

    private String periodPublicId;

    private String description;

    private String canRegisterOnline;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteTs;
}
