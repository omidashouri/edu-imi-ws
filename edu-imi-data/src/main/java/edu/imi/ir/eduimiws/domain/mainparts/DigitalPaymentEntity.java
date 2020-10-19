package edu.imi.ir.eduimiws.domain.mainparts;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_DIGITAL_PAYMENT", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_DIGITAL_PAYMENT")
public class DigitalPaymentEntity extends BaseEntity {


    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "RESNUM")
    private Long resnum;

    @Column(name = "MID", length = 50)
    private String mid;

    @Column(name = "SECTION_NAME", length = 50)
    private String sectionName;

    @Column(name = "SECTION_ID")
    private Long sectionId;

    @Column(name = "REFNUM", length = 50)
    private String refnum;

    @Column(name = "STATE", length = 50)
    private String state;

    @Column(name = "BANK", length = 50)
    private String bank;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "PDATE", length = 10)
    private String pdate;

    @Column(name = "PTIME", length = 10)
    private String ptime;

    @Column(name = "FSTATE", length = 200)
    private String fstate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_ID")
    private ContactEntity contact;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

    @Column(name = "WAGE", precision = 8)
    private Long wage;

    @Column(name = "DISCOUNT")
    private Long discount;

    @Column(name = "SREFID", length = 20)
    private String srefid;

    @Column(name = "HAS_SANAD", length = 1)
    private String hasSanad;
}
