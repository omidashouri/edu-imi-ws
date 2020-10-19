package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;
import java.sql.Timestamp;

public class StudentApiDto implements Serializable {

    private static final long serialVersionUID = 7778649847627058916L;

    private Long id;

    private StudentDto studentDto;
    private Long studentId;

    private PersonDto personDto;
    private Long personId;

    private String studentPublicId;

    private String personPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Long studentDeleteStatus;

    private String studentEditDate;

    private Timestamp deleteDateTs;
}
