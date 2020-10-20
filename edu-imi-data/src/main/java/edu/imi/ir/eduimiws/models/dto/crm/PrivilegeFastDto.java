package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeFastDto implements Serializable {

    private static final long serialVersionUID = 7920669264642005419L;

    private Long id;

    private String privilegePublicId;
    private String name;
}
