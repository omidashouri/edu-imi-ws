package edu.imi.ir.eduimiws.models.api;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataReqres implements Serializable {

    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
