package edu.imi.ir.eduimiws.models.dto.hamkaran;

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
public class HamkaranPaginationDto {

    private Long currentPage;
    private Long pageCount;
    private Long totalItems;
    private Long limit;
    private List<HamkaranLinkDto> links=new ArrayList<>();
}
