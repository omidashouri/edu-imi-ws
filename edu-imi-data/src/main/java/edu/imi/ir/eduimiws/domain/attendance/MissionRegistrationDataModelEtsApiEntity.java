package edu.imi.ir.eduimiws.domain.attendance;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.utilities.attendance.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "ATC", sequenceName = "SEQ_TBL_MISSION_REGISTRATION_DATA_MODEL_ETS_API", allocationSize = 1)
@Table(schema = "ATC", name = "TBL_MISSION_REGISTRATION_DATA_MODEL_ETS_API")
public class MissionRegistrationDataModelEtsApiEntity extends BaseEntity implements Serializable {

    @Column(name = "MISSION_REGISTRATION_ID")
    private Long missionRegistrationId;

    @Column(name = "EMPLOYEE_CODE", length = 100)
    private String employeeCode;

    //  private Long bisinessPartnerId;

    @Column(name = "FULL_NAME", length = 500)
    private String fullName;

    @Column(name = "DAY_OF_WEEK")
    @Convert(converter = DayOfWeekConverter.class)
    private DayOfWeek dayOfWeek;

    @Column(name = "BEGIN_DATE")
    private String beginDate;

    @Column(name = "BEGIN_TIME", length = 10)
    private String beginTime;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "END_TIME", length = 10)
    private String endTime;

    @Column(name = "MISSION_NAME", length = 500)
    private String missionName;

    @Column(name = "MISSION_TYPE")
    @Convert(converter = MissionTypeConverter.class)
    private MissionType missionType;

    @Column(name = "ACCEPTANCE_STATE")
    @Convert(converter = AcceptanceStateConverter.class)
    private AcceptanceState acceptanceState;

    @Column(name = "MISSION_SOURCE_TYPE")
    @Convert(converter = SourceTypeConverter.class)
    private SourceType missionSourceType;
}

