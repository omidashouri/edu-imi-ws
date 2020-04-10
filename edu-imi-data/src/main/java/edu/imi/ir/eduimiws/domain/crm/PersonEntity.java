package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.jpa.QueryHints;

import javax.persistence.*;



@NamedEntityGraphs({
        @NamedEntityGraph(name = "personUserGraph", attributeNodes = {
                @NamedAttributeNode("firstName"),
                @NamedAttributeNode("lastName"),
                @NamedAttributeNode("username"),
                @NamedAttributeNode("contactId"),
                @NamedAttributeNode("companyId")
        }),
        @NamedEntityGraph(name = "PersonEntity.personIdProjectionGraph", attributeNodes = {
                @NamedAttributeNode("id")
        })
})
@SqlResultSetMapping(
    name = "personUserProjection",
    classes = {
        @ConstructorResult(
            targetClass = PersonUserProjection.class,
            columns = {
                    @ColumnResult(name = "id", type = Long.class),
                    @ColumnResult(name = "contactId", type = Long.class),
                    @ColumnResult(name = "companyId", type = Long.class),
                    @ColumnResult(name = "username", type = String.class),
                    @ColumnResult(name = "password", type = String.class)
            }
        )
    }
)
@NamedNativeQueries({
    @NamedNativeQuery(name = "PersonEntity.findAllPersonUserProjection",
        query = " select per.ID as id, " +
                " per.CONTACT_ID as contactId, per.COMPANY_ID as companyId, " +
                " per.USERNAME as username, per.PASSWORD as password " +
                " from CRM.TBL_PERSON per ",
        resultSetMapping = "personUserProjection"
    ),
    @NamedNativeQuery(name = "PersonEntity.findPersonUserProjectionsByIdGreaterThan",
            query = " select per.ID as id, " +
                    " per.CONTACT_ID as contactId, per.COMPANY_ID as companyId, " +
                    " per.USERNAME as username, per.PASSWORD as password " +
                    " from CRM.TBL_PERSON per where per.ID > :personId ",
            resultSetMapping = "personUserProjection"
    ),
    @NamedNativeQuery(name = "PersonEntity.selectCurrentSequenceNumber",
            query = " select SEQ_PERSON_ID.nextval from dual "
    )

})
@NamedQueries({
        @NamedQuery(name = "PersonEntity.selectPersonEntityByIdM",
        query = "select per.id from PersonEntity per where per.id > :personId",
                hints = @QueryHint(name = QueryHints.HINT_READONLY,value = "true")
        )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_PERSON_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_PERSON")
public class PersonEntity extends BaseEntity {

    @PrePersist
    void preInsert() {
        if (null == this.getSelectedLanguage()) {
            LanguageEntity languageEntity = new LanguageEntity();
            languageEntity.setId(1l);
            this.selectedLanguage = languageEntity;
        }
        if (null == this.getCompany()) {
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setId(4l);
            this.setCompany(companyEntity);
        }
    }

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LIMITATION_NUMBER")
    private Long limitationNumber;

    @Column(name = "SIGNATURE")
    private String signature;

    @Column(name = "LASTLOGINDATE")
    private String lastlogindate;

    //    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", nullable = false, columnDefinition = " Long default '4' ")
    @ColumnDefault("4")
    private CompanyEntity company;

    @Column(name = "COMPANY_ID", insertable = false, updatable = false)
    private Long companyId;

    @Transient
    public Long getCompanyId() {
        return companyId;
    }

    //    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_ID")
    private ContactEntity contact;

    @Column(name = "CONTACT_ID", insertable = false, updatable = false)
    private Long contactId;

    @Transient
    public Long getContactId() {
        return contactId;
    }

    @Column(name = "SELECTED_SKIN")
    private String selectedSkin;

    //    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELECTED_LANGUAGE", nullable = false)
    private LanguageEntity selectedLanguage;

    @Column(name = "EMAIL_PROCESS_TYPE")
    private String emailProcessType;

    @Column(name = "PERSONAL_CODE")
    private String personalCode;

    @Column(name = "ACTIVITY_STATUS")
    private String activityStatus;

    @Column(name = "KIND")
    private String kind;

    //    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_POSITION_ID")
    private OrganizationClassEntity organizationPosition;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "OWNER_ID")
    private PersonEntity owner;

    //    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_CLASS_ID")
    private OrganizationClassEntity organizationClass;

    @Column(name = "NOE_ESTEKHDAM")
    private String noeEstekhdam;

    @Column(name = "PWDP")
    private String pwdp;

    @Column(name = "SIGNATURE_IMG")
    private String signatureImg;

    //    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMERCE_ADDITIONAL_INFO")
    private PersonInfoCommerceEntity commerceAdditionalInfo;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy="person",fetch = FetchType.LAZY)
    private PersonWebServiceEntity personWebServiceEntity;
}
