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
    private Base64 family;
    private int familyHasPerfix;
    private int familyHasPostfix;
    private Base64 fatherName;
    private int gender;
    private Base64 name;
    private int nameHasPerfix;
    private int nameHasPostfix;
    private long nin;
    private int officeCode;
    private Base64 officeName;
    private int shenasnameNo;
    private Base64 shenasnameSeri;
    private int shenasnameSerial;
}
