package edu.imi.ir.eduimiws.models.response.hamkaran.v1;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranPagination {

    private Long currentPage;
    private Long pageCount;
    private Long totalItems;
    private Long limit;
    private List<HamkaranLink> links=new ArrayList<>();
}
