package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;

public class PeriodCertificateDto implements Serializable {

    private static final long serialVersionUID = -4718153424515081978L;

    private Long id;

    private RegisterDto registerDto;
    private Long registerId;
    private String registerPublicId;

    private String activityStatus;

    private String certificateDate;

    private String certificateNumber;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String editorDate;

    private Long certificateTemplateId;

    private String certificateText;

    private String deliveryDate;

    private String deliveryPerson;

    private String description;

    private String planNumber;

    private String pdf;

    private String pdfDate;

    private PersonDto pdfPersonDto;
    private Long pdfPersonId;
    private String pdfPersonPublicId;

    private String backPdf;

    private String backPdfDate;

    private PersonDto backPdfPersonDto;
    private Long backPdfPersonId;
    private String backPdfPersonPublicId;

    private String hologramNumber;

    private String isold;

    private String oldText;

    private String hasError;

    private String oldPdf;

    private String isReplica;

    private String rFishNo;

    private String rFishDate;

    private String rReqNo;

    private String rReqDate;

    private String rFishFile;

    private String rReqFile;

    private Long certificateEnStatus;

    private String certificateEnCreateDate;

    private PersonDto certificateEnCreatorDto;
    private Long certificateEnCreatorId;
    private String certificateEnCreatorPublicId;

    private String isedited;

    private PeriodCertificateApiDto periodCertificateApiDto;
    private Long periodCertificateApiId;
    private String periodCertificatePublicId;
}
