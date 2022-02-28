package edu.imi.ir.eduimiws.models.dto.hamkaran;

import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherListItemsApiDto;
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
public class HamkaranFinancialResponseDto {

    private HamkaranStatusDto status;

    private HamkaranPaginationDto pagination;

//    voucherListItemsApiDtos ia same as data
    private List<VoucherListItemsApiDto> voucherListItemsApiDtos= new ArrayList<>();

    private HamkaranHeaderDto headers;

    private String searchQuery;
}
