package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PERIOD_CERTIFICATE", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PERIOD_CERTIFICATE")
public class PeriodCertificateEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterEntity register;

    @Column(name = "ACTIVITY_STATUS", length = 3)
    private String activityStatus;

    @Column(name = "CERTIFICATE_DATE", length = 10)
    private String certificateDate;

    @Column(name = "CERTIFICATE_NUMBER", length = 50)
    private String certificateNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "EDITOR_DATE", length = 10)
    private String editorDate;

    //TblCertficateTemplate
    @Column(name = "CERTIFICATE_TEMPLATE_ID")
    private Long certificateTemplateId;

    @Lob
    @Column(name = "CERTIFICATE_TEXT")
    private String certificateText;

    @Column(name = "DELIVERY_DATE", length = 10)
    private String deliveryDate;

    @Column(name = "DELIVERY_PERSON", length = 50)
    private String deliveryPerson;

    @Column(name = "DESCRIPTION", length = 3000)
    private String description;

    @Column(name = "PLAN_NUMBER", length = 30)
    private String planNumber;

    @Column(name = "PDF", length = 50)
    private String pdf;

    @Column(name = "PDF_DATE", length = 10)
    private String pdfDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PDF_PERSON_ID")
    private PersonEntity pdfPerson;

    @Column(name = "BACK_PDF", length = 50)
    private String backPdf;

    @Column(name = "BACK_PDF_DATE", length = 10)
    private String backPdfDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BACK_PDF_PERSON_ID")
    private PersonEntity backPdfPerson;

    @Column(name = "HOLOGRAM_NUMBER", length = 102)
    private String hologramNumber;

    @Column(name = "ISOLD", length = 20)
    private String isold;

    @Column(name = "OLD_TEXT", length = 4000)
    private String oldText;

    @Column(name = "HAS_ERROR", length = 1)
    private String hasError;

    @Column(name = "OLD_PDF", length = 50)
    private String oldPdf;

    @Column(name = "IS_REPLICA", length = 1)
    private String isReplica;

    @Column(name = "R_FISH_NO", length = 50)
    private String rFishNo;

    @Column(name = "R_FISH_DATE", length = 10)
    private String rFishDate;

    @Column(name = "R_REQ_NO", length = 20)
    private String rReqNo;

    @Column(name = "R_REQ_DATE", length = 10)
    private String rReqDate;

    @Column(name = "R_FISH_FILE", length = 50)
    private String rFishFile;

    @Column(name = "R_REQ_FILE", length = 50)
    private String rReqFile;

    @Column(name = "CERTIFICATE_EN_STATUS")
    private Long certificateEnStatus;

    @Column(name = "CERTIFICATE_EN_CREATE_DATE", length = 10)
    private String certificateEnCreateDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CERTIFICATE_EN_CREATOR_ID")
    private PersonEntity certificateEnCreator;

    @Column(name = "ISEDITED", length = 20)
    private String isedited;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "periodCertificate", fetch = FetchType.LAZY)
    private PeriodCertificateApiEntity periodCertificateApi;
}
