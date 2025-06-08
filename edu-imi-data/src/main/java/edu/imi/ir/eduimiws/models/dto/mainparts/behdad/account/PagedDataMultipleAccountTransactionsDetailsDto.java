package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import edu.imi.ir.eduimiws.models.wsdl.behdad.BankTransaction;
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
    private List<BankTransaction> bankTransactionWsdls = new ArrayList<>();
    private List<BankTransactionDto> bankTransactionDtos = new ArrayList<>();

    public void castObjectsTobankTransactionWsdls() {
        if (isBankTransactionWsdlsNull()) {
            if (currentPageData != null && currentPageData.size() > 0) {
                this.currentPageData.stream()
                        .map(p -> (BankTransaction) p)
                        .forEach(bankTransactionWsdls::add);
            }
        }
    }

    public boolean isBankTransactionWsdlsNull() {
        return bankTransactionWsdls == null || bankTransactionWsdls.isEmpty();
    }

    public boolean isBankTransactionDtosNull() {
        return bankTransactionDtos == null || bankTransactionDtos.isEmpty();
    }
}
