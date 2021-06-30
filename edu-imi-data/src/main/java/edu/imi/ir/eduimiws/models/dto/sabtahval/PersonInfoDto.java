package edu.imi.ir.eduimiws.models.dto.sabtahval;


import lombok.*;

import java.io.Serializable;
import java.util.Base64;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfoDto implements Serializable {

    private int birthDate;
    private int bookNo;
    private int bookRow;
    private int dateHasPostfix;
    private byte[] family;
    private String familyString;
    private int familyHasPerfix;
    private int familyHasPostfix;
    private byte[] fatherName;
    private String fatherNameString;
    private int gender;
    private byte[] name;
    private String nameString;
    private int nameHasPerfix;
    private int nameHasPostfix;
    private long nin;
    private int officeCode;
    private byte[] officeName;
    private String officeNameString;
    private int shenasnameNo;
    private byte[] shenasnameSeri;
    private String shenasnameSeriString;
    private int shenasnameSerial;
}
