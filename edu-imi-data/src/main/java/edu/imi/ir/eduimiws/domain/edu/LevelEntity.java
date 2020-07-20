package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import javax.persistence.*;

@NamedNativeQueries({
        @NamedNativeQuery(name = "LevelEntity.selectCurrentSequenceNumber",
                query = " select  EDU.SEQ_EDU_LEVEL.nextval from dual "
        )
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_LEVEL", allocationSize = 1)
@Table(schema = "EDU",name="TBL_LEVEL")
public class LevelEntity extends BaseEntity {

    @Column(name="DESCRIPTION",length = 150)
    private String description;

    @Column(name="CODE",length = 10)
    private String code;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name="TERMIC_STATUS",length = 10)
    private String termicStatus;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name="CREATE_DATE",length = 10)
    private String createDate;

    @Column(name="EDIT_DATE",length = 10)
    private String editDate;

    @Column(name="PAYMENT_TYPE",length = 1)
    private String paymentType;

    @Column(name="TITLE",length = 50)
    private String title;

    @Column(name="CERT_TITLE",length = 50)
    private String certTitle;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private LevelApiEntity levelApi;
}
