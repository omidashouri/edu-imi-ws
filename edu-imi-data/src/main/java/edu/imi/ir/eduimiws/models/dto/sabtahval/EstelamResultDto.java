package edu.imi.ir.eduimiws.models.dto.sabtahval;

import lombok.*;
import lombok.experimental.SuperBuilder;


import java.io.Serializable;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstelamResultDto implements Serializable {

    protected int birthDate;
    protected int bookNo;
    protected int bookRow;
    protected int deathStatus;
    protected byte[] family;
    protected String familyString;
    protected byte[] fatherName;
    protected String fatherNameString;
    protected int gender;
    protected List<String> messages;
    protected byte[] name;
    protected String nameString;
    protected long nin;
    protected int officeCode;
    protected byte[] officeName;
    protected String officeNameString;
    protected int shenasnameNo;
    protected byte[] shenasnameSeri;
    protected String shenasnameSeriString;
    protected int shenasnameSerial;
}
