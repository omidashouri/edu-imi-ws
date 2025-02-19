package edu.imi.ir.eduimiws.domain.atc;

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
@SequenceGenerator(name = "entity_sequence", schema = "ATC", sequenceName = "SEQ_DAYMOR_ETS_API", allocationSize = 1)
@Table(schema = "ATC", name = "TBL_DAYMOR_ETS_API")

public class DayMorEtsApiEntity extends BaseEntity {

    @Column(name = "PAGENO")
    private Long pageNo;

    @Column(name = "PERNO", length = 10)
    private String perNo;

    @Column(name = "BEGINDATE", length = 5)
    private String beginDate;

    @Column(name = "ENDDATE", length = 5)
    private String endDate;

    @Column(name = "DESCRIPT", length = 230)
    private String descript;

    @Column(name = "RECDATE", length = 5)
    private String recDate;

    @Column(name = "TYPE")
    private Long type;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

    //@EqualsAndHashCode.Exclude
    //@ToString.Exclude
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "CREATOR)
    // private PersonEntity creator;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_sequence")
    @Column(name = "ID")
    private Long id;


    @Column(name = "YEAR", length = 4)
    private String year;
}
