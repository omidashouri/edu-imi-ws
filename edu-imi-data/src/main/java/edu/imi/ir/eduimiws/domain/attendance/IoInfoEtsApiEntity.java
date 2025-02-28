package edu.imi.ir.eduimiws.domain.attendance;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "ATC", sequenceName = "SEQ_IO_INFO_ETS_API", allocationSize = 1)
@Table(schema = "ATC", name = "TBL_IO_INFO_ETS_API")

public class IoInfoEtsApiEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name="PERNO",length = 10)
    private String perNo;

    @Column(name="BEGINDATE",length = 5)
    private String beginDate;

    @Column(name="BEGINTIME",length = 5)
    private String beginTime;

    @Column(name="ENDDATE",length = 5)
    private String endDate;

    @Column(name = "ENDTIME", length = 5)
    private String endTime;

    @Column(name="BBEGINTIME",length = 5)
    private String bBeginTime;

    @Column(name="BENDDATE",length = 5)
    private String bEndDate;

    @Column(name="BENDTIME",length = 5)
    private String bEndTime;

    @Column(name="BEGINCLOCK",length = 3)
    private String beginClock;

    @Column(name="ENDCLOCK",length = 3)
    private String endClock;

    @Column(name="DURATION")
    private Long duration;

    @Column(name="BEGINCOMECODE")
    private Long beginComeCode;

    @Column(name="ENDCOMCODE")
    private Long endComeCode;

    @Column(name="FPM",length = 1)
    private String fpm;

    @Column(name="ENTERPICID")
    private Long enterPicId;

    @Column(name="EXITPICID")
    private Long exitPicId;

    @Column(name="LASTEDITUSERCODE",length = 3)
    private String lastEditUserCode;

    @Column(name="LASTEDITDATE",length = 5)
    private String lastEditTime;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;



    @Column(name="YEAR",length = 4)
    private String year;
}
