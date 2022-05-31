package edu.imi.ir.eduimiws.models.dto.crm;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarapayamakDto implements Serializable {

    private static final long serialVersionUID = -4740565908314583125L;

    private String username;

    private String password;

    private String to;

    private List<String> toes;

    private String from;

    private String text;

    private Boolean isFlash;

    private String value;

    private List<String> values;

    private Integer retStatus;

    private String strRetStatus;

    private Long fakeLong = 1L;

    private String fakeString = "fake";

    private LocalDateTime localDateTimeNow = LocalDateTime.now();

    private Long creatorId;

    private String creatorFullName;

}
