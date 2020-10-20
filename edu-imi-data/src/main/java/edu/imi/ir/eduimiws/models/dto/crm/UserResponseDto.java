package edu.imi.ir.eduimiws.models.dto.crm;


import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto implements Serializable {

    private static final long serialVersionUID = -335726670067224018L;

    private Long id;

    private String userPublicId;
    private String contactPublicId;

    private String firstName;
    private String lastName;
    private String userName;

    private List<UserContactResponseDto> userContactResponseDtos = new ArrayList<>();
}
