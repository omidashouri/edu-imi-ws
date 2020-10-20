package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreRegisterApiDto implements Serializable {

    private static final long serialVersionUID = -417001585765279278L;

    private Long id;

    private PreRegisterDto preRegisterDto;
    private Long preRegisterId;

    private PeriodDto periodDto;
    private Long periodId;

    private ContactDto contactDto;
    private Long contactId;

    private String preRegisterPublicId;

    private String periodPublicId;

    private String contactPublicId;

    private Long preRegisterDeleteStatus;

    private Long preRegisterActivityStatus;

    private String preRegisterEditDate;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private Long deletedPreRegisterId;
}
