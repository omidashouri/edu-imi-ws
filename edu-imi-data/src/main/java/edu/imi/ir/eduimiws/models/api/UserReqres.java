package edu.imi.ir.eduimiws.models.api;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReqres implements Serializable {
    private DataReqres data;
    private AdReqres ad;
}
