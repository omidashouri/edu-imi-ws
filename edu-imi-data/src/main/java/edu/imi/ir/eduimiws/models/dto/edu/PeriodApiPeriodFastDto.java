package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodApiPeriodFastDto implements Serializable {

    private static final long serialVersionUID = 5815734885605837343L;

    private PeriodFastDto periodFastDto;

    private String periodPublicId;

    private String description;

    private String canRegisterOnline;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteTs;
}
