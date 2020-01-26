package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PERSON_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_PERSON")
public class PersonEntity extends BaseEntity {

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="TEL")
    private String tel;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="EMAIL")
    private String email;

    @Column(name="WEBSITE")
    private String website;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="LIMITATION_NUMBER")
    private Long limitationNumber;

    @Column(name="SIGNATURE")
    private String signature;

    @Column(name="LASTLOGINDATE")
    private String lastlogindate;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID",nullable = false,columnDefinition = " long default 4 ")
    private CompanyEntity companyId;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    private ContactEntity contactId;
/*    @Column(name="CONTACT_ID")
    private Long contactId;*/

    @Column(name="SELECTED_SKIN")
    private String selectedSkin;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELECTED_LANGUAGE",nullable = false,columnDefinition = " long default 1 ")
    private LanguageEntity selectedLanguage;

    @Column(name="EMAIL_PROCESS_TYPE")
    private String emailProcessType;

    @Column(name="PERSONAL_CODE")
    private String personalCode;

    @Column(name="ACTIVITY_STATUS")
    private String activityStatus;

    @Column(name="KIND")
    private String kind;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORGANIZATION_POSITION_ID")
    private OrganizationClassEntity organizationPositionId;

    @OneToOne(optional = true)
    @JoinColumn(name = "OWNER_ID")
    private PersonEntity ownerId;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORGANIZATION_CLASS_ID")
    private OrganizationClassEntity organizationClassId;

    @Column(name="NOE_ESTEKHDAM")
    private String noeEstekhdam;

    @Column(name="PWDP")
    private String pwdp;

    @Column(name="SIGNATURE_IMG")
    private String signatureImg;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMMERCE_ADDITIONAL_INFO")
    private PersonInfoCommerceEntity commerceAdditionalInfo;
}
