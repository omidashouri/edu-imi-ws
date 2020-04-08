package edu.imi.ir.eduimiws.models.dto.crm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto implements Serializable {

    private String userPublicId;
    private String contactPublicId;

    private String firstName;
    private String lastName;
    private String userName;

    private List<UserContactResponseDto> userContactResponseDtos = new ArrayList<>();
}
