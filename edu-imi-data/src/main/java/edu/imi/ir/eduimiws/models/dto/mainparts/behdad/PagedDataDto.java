package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedDataDto implements Serializable {

    private static final long serialVersionUID = 5993971974209193660L;
    private List<Object> currentPageData;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalCount;

}
