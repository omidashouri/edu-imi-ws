package edu.imi.ir.eduimiws.domain.attendance;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.utilities.attendance.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "ATC", sequenceName = "SEQ_TBL_IORECORD_DATA_MODEL_ETS_API", allocationSize = 1)
@Table(schema = "ATC", name = "TBL_IORECORD_DATA_MODEL_ETS_API")
public class IoRecordDataModelEtsApiEntity  extends BaseEntity implements Serializable {

    @Column(name = "IORECORD_ID")
    private Long ioRecordId;

    @Column(name = "EMPLOYEE_CODE", length = 100)
    private String employeeCode;

    @Column(name = "DAY_OF_WEEK")
    @Convert(converter = DayOfWeekConverter.class)
    private DayOfWeek dayOfWeek;

    @Column(name = "FINAL_JALALI_DATE", length = 10)
    private String jalaliDate;

    @Column(name = "FINAL_TIME", length = 10)
    private String time;

    @Column(name = "FINAL_RECORDIO_TYPE")
    @Convert(converter = RecordIoTypeConverter.class)
    private RecordIoType recordIoType;

    @Column(name = "ACCEPTANCE_STATE")
    @Convert(converter = AcceptanceStateConverter.class)
    private AcceptanceState acceptanceState;

    @Column(name = "IOSOURCE_TYPE")
    @Convert(converter = SourceTypeConverter.class)
    private SourceType sourceType;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DESCRIPYION", length = 200)
    private String Description;

}
