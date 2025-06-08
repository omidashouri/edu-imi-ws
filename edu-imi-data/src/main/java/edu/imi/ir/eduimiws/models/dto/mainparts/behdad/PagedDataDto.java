package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BankTransactionDto;
import edu.imi.ir.eduimiws.models.wsdl.behdad.BankTransaction;
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
    private List<BankTransaction> bankTransactionWsdls;
    private List<BankTransactionDto> bankTransactionDtos;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalCount;


    public boolean isCurrentPageDataNull() {
        return currentPageData == null || currentPageData.isEmpty();
    }

    public boolean isBankTransactionWsdlsNull() {
        return bankTransactionWsdls == null || bankTransactionWsdls.isEmpty();
    }

    public boolean isBankTransactionDtosNull() {
        return bankTransactionDtos == null || bankTransactionDtos.isEmpty();
    }

}
