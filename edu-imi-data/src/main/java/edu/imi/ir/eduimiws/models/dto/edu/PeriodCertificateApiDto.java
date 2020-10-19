package edu.imi.ir.eduimiws.models.dto.edu;


import java.io.Serializable;
import java.sql.Timestamp;

public class PeriodCertificateApiDto implements Serializable {

    private static final long serialVersionUID = -2491478410448001023L;

    private Long id;

    private PeriodCertificateDto periodCertificateDto;
    private Long periodCertificateId;

    private String periodCertificatePublicId;

    private Long deletedPeriodCertificateId;

    private RegisterDto registerDto;
    private Long registerId;

    private String registerPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private StudentDto studentDto;
    private Long studentId;

    private String studentPublicId;

    private PeriodDto periodDto;
    private Long periodId;
    private String periodPublicId;
}
