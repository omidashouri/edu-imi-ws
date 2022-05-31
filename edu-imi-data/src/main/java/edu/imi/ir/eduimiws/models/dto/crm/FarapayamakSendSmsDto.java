package edu.imi.ir.eduimiws.models.dto.crm;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarapayamakSendSmsDto implements Serializable {

    private static final long serialVersionUID = -2131358828511370225L;

    private String username;

    private String password;

    private String to;

    private String from;

    private String text;

    private Boolean isFlash;

    private Long creatorId;
    private String creatorFullName;


}
