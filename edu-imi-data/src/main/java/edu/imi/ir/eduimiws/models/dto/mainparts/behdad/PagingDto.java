package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagingDto implements Serializable {

    private static final long serialVersionUID = 8247529348907780279L;
    private Long id;
    private Integer pageNumber;
    private Integer recordCount;
}
