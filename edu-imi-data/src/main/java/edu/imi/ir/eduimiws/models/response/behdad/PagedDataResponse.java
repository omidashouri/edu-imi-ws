package edu.imi.ir.eduimiws.models.response.behdad;


import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
public class PagedDataResponse<T> {

    List<T> currentPageData;
    Integer pageNumber;
    Integer pageSize;
    Long totalCount;
}
