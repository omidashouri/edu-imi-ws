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
public class HamkaranHumanResourceResponseDto {

    private HamkaranStatusDto statusDto;

    private HamkaranPaginationDto paginationDto;

    private List<HamkaranHumanResourceDataDto> dataDto= new ArrayList<>();

    private HamkaranHeaderDto headersDto;

    private String searchQuery;

}
