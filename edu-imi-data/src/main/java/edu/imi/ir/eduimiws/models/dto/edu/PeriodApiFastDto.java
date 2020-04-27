package edu.imi.ir.eduimiws.models.dto.edu;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodApiFastDto implements Serializable {

    private static final long serialVersionUID = 4246939209926794747L;

    private Long id;

    private Long periodId;

    private String periodPublicId;

    private String periodEditDate;

    private String description;

    private String canRegisterOnline;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteTs;
}
