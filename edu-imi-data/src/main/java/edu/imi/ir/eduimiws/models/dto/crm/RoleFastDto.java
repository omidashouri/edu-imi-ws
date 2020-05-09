package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleFastDto implements Serializable {

    private static final long serialVersionUID = -5210690329005619034L;

    private String rolePublicId;
    private String name;
    private Set<PrivilegeFastDto> privilegeFastDtos;
}
