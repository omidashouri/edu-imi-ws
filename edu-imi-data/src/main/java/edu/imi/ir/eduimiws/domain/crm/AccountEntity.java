package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "AccountEntity.findAccountContactCompany",
                attributeNodes = {
                        @NamedAttributeNode("company"),
                        @NamedAttributeNode("primaryContact"),
                        @NamedAttributeNode("accountApi")
                }
        ),
        @NamedEntityGraph(name = "AccountEntity.findAccountApi",
                attributeNodes = {
                        @NamedAttributeNode("accountApi")
                }
        ),
        @NamedEntityGraph(name = "AccountEntity.findAllJoins",
                attributeNodes = {

                        @NamedAttributeNode("company"),
                        @NamedAttributeNode("parentAccount"),
                        @NamedAttributeNode("primaryContact"),
                        @NamedAttributeNode("language"),
                        @NamedAttributeNode("currency"),
                        @NamedAttributeNode("country"),
                        @NamedAttributeNode("state"),
                        @NamedAttributeNode("city"),
                        @NamedAttributeNode("addressType"),
                        @NamedAttributeNode("region"),
                        @NamedAttributeNode("userCreator"),
                        @NamedAttributeNode("userLastEditor"),
                        @NamedAttributeNode("userFollower"),
                        @NamedAttributeNode("siteCity"),
                        @NamedAttributeNode("employee"),
                        @NamedAttributeNode("annualRevenueEntity"),
                        @NamedAttributeNode("accountApi")
                }
        )
})


@NamedQueries({
        @NamedQuery(name = "AccountEntity.queryPageableAccountForPaymentCodeProjection",
                query = " select " +
                        " acc.id as id," +
                        " acca.accountPublicId as accountPublicId," +
                        " acc.economicalCode as economicalCode, " +
                        " acc.accountName as accountName, " +
                        " acc.mainPhone as mainPhone," +
                        " acc.otherPhone as otherPhone" +
                        " from " +
                        " AccountEntity acc " +
                        " left join acc.accountApi acca " +
                        " where " +
                        " ( :id is null or acc.id = :id ) AND " +
                        " ( :accountPublicId is null or acca.accountPublicId = :accountPublicId ) AND " +
                        " ( :economicalCode is null or acc.economicalCode = :economicalCode ) AND " +
                        " ( :accountName is null or acc.accountName like concat('%',:accountName,'%') ) AND " +
                        " ( :mainPhone is null or acc.mainPhone like concat('%',:mainPhone,'%') ) AND " +
                        " ( :otherPhone is null or acc.otherPhone like concat('%',:otherPhone,'%') ) "
                /*       " ORDER BY acc.lastName desc NULLS LAST "
                hints =  {
                        @QueryHint( name = QueryHints.HINT_FLUSH_MODE, value = "AUTO" ),
                        @QueryHint(name = QueryHints.HINT_CACHEABLE, value = "true"),
                        @QueryHint(name = QueryHints.HINT_READONLY,value = "true"),
                        @QueryHint( name = QueryHints.HINT_COMMENT, value = "use cache for named query" ),
                },
                lockMode = LockModeType.READ*/
        )
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_ACCOUNT_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_ACCOUNT")
public class AccountEntity extends BaseEntity {

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false, columnDefinition = " Long default '4' ")
    private CompanyEntity company;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ACCOUNT_ID")
    private AccountEntity parentAccount;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRIMARY_CONTACT_ID")
    private ContactEntity primaryContact;

    //  TBL_CATEGORY
    @Column(name = "RELATION_TYPE_ID")
    private Long relationTypeId;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LANGUAGE_ID")
    private LanguageEntity language;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private ParameterEntity currency;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "OWNERSHIP")
    private String ownership;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "MAIN_PHONE")
    private String mainPhone;

    @Column(name = "OTHER_PHONE")
    private String otherPhone;

    @Column(name = "FAX_NUMBER")
    private String faxNumber;

    @Column(name = "WEB_SITE")
    private String webSite;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TICKER_SYMBOL")
    private String tickerSymbol;

    @Column(name = "EMPLOYEES")
    private String employees;

    @Column(name = "ANNUAL_REVENUE")
    private String annualRevenue;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private ParameterEntity country;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATE_ID")
    private ParameterEntity state;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private ParameterEntity city;

    @Column(name = "ADDRESS_PHONE")
    private String addressPhone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION")
    private String description;

    //  TBL_INDUSTRY
    @Column(name = "INDUSTRY_ID")
    private Long industryId;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_TYPE")
    private ParameterEntity addressType;

    @Column(name = "ACCOUNT_LOGO")
    private String accountLogo;

    @Column(name = "PRINT_LOGO")
    private String printLogo;

    @Column(name = "PRINT_TITLE1")
    private String printTitle1;

    @Column(name = "PRINT_TITLE2")
    private String printTitle2;

    @Column(name = "PRINT_TITLE3")
    private String printTitle3;

    @Column(name = "PRINT_ADDRESS_TITLE")
    private String printAddressTitle;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private ParameterEntity region;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_CREATOR_ID")
    private PersonEntity userCreator;

    @Column(name = "CREATE_DATE")
    private String createDate;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_LAST_EDITOR_ID")
    private PersonEntity userLastEditor;

    @Column(name = "LAST_EDIT_DATE")
    private String lastEditDate;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_FOLLOWER_ID")
    private ContactEntity userFollower;

    @Column(name = "GENERAL_CODE")
    private String generalCode;

    @Column(name = "SPECIFIC_CODE")
    private String specificCode;

    @Column(name = "DETAILED_CODE")
    private String detailedCode;

    @Column(name = "PRIMARY_SALES_MAN_ID")
    private String primarySalesManId;

    @Column(name = "SECONDARY_SALES_MAN_ID")
    private String secondarySalesManId;

    @Column(name = "PATH_ID")
    private String pathId;

    @Column(name = "ACCESS_TYPE")
    private String accessType;

    @Column(name = "VERIFIED")
    private String verified;

    //  TBL_ACCOUNT_ADDITIONAL_INFO
    @Column(name = "ACCOUNT_ADDITIONAL_INFO_ID")
    private Long accountAdditionalInfoId;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String address3;

    @Column(name = "ACCOUNT_EN_NAME")
    private String accountEnName;

    @Column(name = "STOCK_TYPE")
    private String stockType;

    @Column(name = "IS_HOLDING")
    private String isHolding;

    //  TBL_ORGANIZATION_TYPE
    @Column(name = "ORG_TYPE_ID")
    private Long orgTypeId;

    @Column(name = "TYPE_OF_ACTIVITY")
    private String typeOfActivity;

    @Column(name = "IS_IN_STOCK")
    private String isInStock;

    @Column(name = "UTILIZATION_YEAR")
    private String utilizationYear;

    @Column(name = "SITE_PHONE")
    private String sitePhone;

    @Column(name = "SITE_FAX")
    private String siteFax;

    @Column(name = "SITE_ADDRESS")
    private String siteAddress;

    @Column(name = "STOCK_HOLDERS")
    private String stockHolders;

    //  TBL_INPEA_ADDITIONAL_INFO
    @Column(name = "INPEA_ADDITIONAL_INFO")
    private Long inpeaAdditionalInfo;

    @Column(name = "SUB_SYS")
    private String subSys;

    @Column(name = "IBMC_ADDITIONAL_INFO")
    private Long ibmcAdditionalInfo;

    //  @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SITE_CITY_ID")
    private ParameterEntity siteCity;

    @Column(name = "SITE_STATE_ID")
    private String siteStateId;

    @Column(name = "STOCK_OTHER_TYPE")
    private String stockOtherType;

    @Column(name = "POST_CODE")
    private String postCode;

    @Column(name = "PRE_PHONE")
    private String prePhone;

    @Column(name = "ECONOMICAL_CODE")
    private String economicalCode;

    @Column(name = "ORG_NATIONAL_CODE")
    private String orgNationalCode;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private ParameterEntity employee;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANNUAL_REVENUE_ID")
    private ParameterEntity annualRevenueEntity;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private AccountApiEntity accountApi;

}
