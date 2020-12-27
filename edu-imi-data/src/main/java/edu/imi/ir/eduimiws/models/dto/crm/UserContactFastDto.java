package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContactFastDto implements Serializable {

    private static final long serialVersionUID = 1799199875904475310L;

    private Long id;

    private String personPublicId;
    private String contactPublicId;

    UserContactResponseDto userContactResponseDto;

}
