package edu.imi.ir.eduimiws.models.dto.hamkaran;


import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherDeleteItemsApiDto;
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
public class HamkaranDeletedFinancialResponseDto {

    private HamkaranStatusDto status;

//    voucherDeleteItemsApiDtos is same as deleted
    private List<VoucherDeleteItemsApiDto> voucherDeleteItemsApiDtos= new ArrayList<>();

    private HamkaranPaginationDto pagination;

    private String searchQuery;
}
