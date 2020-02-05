package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContactFastDto implements Serializable {

    private static final long serialVersionUID = 1799199875904475310L;

    private String personPublicId;
    private String contactPublicId;

    ContactFastDto contactFastDto;

}
