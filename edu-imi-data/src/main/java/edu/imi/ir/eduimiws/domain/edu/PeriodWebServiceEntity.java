package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
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
@SequenceGenerator(name = "entity_sequence", schema = "EDU",sequenceName = "SEQ_PERIOD_WEB_SERVICE",allocationSize = 1)
@Table(schema = "EDU",name="TBL_PERIOD_WEB_SERVICE")
public class PeriodWebServiceEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "PERIOD_ID")
    private PeriodEntity period;

    @Column(name="PERIOD_PUBLIC_ID")
    private String periodPublicId;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CAN_REGISTER_ONLINE")
    private String canRegisterOnline;

    @Column(name="CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name="DELETE_TS")
    private java.sql.Timestamp deleteTs;
}