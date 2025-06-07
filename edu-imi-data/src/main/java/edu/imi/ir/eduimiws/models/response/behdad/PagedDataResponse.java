package edu.imi.ir.eduimiws.models.response.behdad;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class PagedDataResponse {

    Integer pageNumber;
    Integer pageSize;
    Long totalCount;
}
