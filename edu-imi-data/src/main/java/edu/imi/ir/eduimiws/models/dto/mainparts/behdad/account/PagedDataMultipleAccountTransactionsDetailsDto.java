package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import edu.imi.ir.eduimiws.models.wsdl.behdad.PagedData;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Omid Ashouri on 6/7/25 1:32 PM
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedDataMultipleAccountTransactionsDetailsDto extends PagedData implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Object> currentPageData;
    private List<AccountTransactionsDetailDto> accountTransactionsDetailDtos = new ArrayList<>();

    public void castObjectsToTransactionDetails() {
        if (currentPageData != null && currentPageData.size() >0) {
            this.currentPageData.stream()
                    .map(p->(AccountTransactionsDetailDto) p)
                    .forEach(accountTransactionsDetailDtos::add);
        }
    }
}
