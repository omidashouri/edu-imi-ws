package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedDataDto implements Serializable {

    private static final long serialVersionUID = 5993971974209193660L;
    private List<Object> currentPageData;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalCount;

}
