package edu.imi.ir.eduimiws.services.mainparts;

//import edu.imi.ir.eduimiws.models.behdad.account.*;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.ChangePasswordRequestDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagedDataDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagingDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.*;

import java.util.List;

public interface BehdadAccountService {

    List<String> getAccountNumbers() ;

    void changePassword(ChangePasswordRequestDto changePasswordRequestDto) ;

    void clearAccountControlType( String accountNumber, String identifierType) ;

    BalanceInfoDto getAccountBalance( String accountNumber) ;

    String getAccountControlType( String accountNumber, String identifierType);

    PagedDataDto getBankTransactionDetails( AccountTransactionFilterDto accountTransactionFilterDto, PagingDto pagingDto) ;

    List<AccountTransactionInfoDto> getDestinationSideTransactions( String accountNumber, long transactionId) ;

    PagedDataDto getMultipleAccountTransactionsDetails( MultipleAccountTransactionFilterDto multipleAccountTransactionFilterDto, PagingDto pagingDto) ;

    PagedDataDto getPagedDestinationSideTransactions( SideTransactionsRequestDto sideTransactionsRequestDto, PagingDto pagingDto) ;

    PagedDataDto getPagedSourceSideTransactions( SideTransactionsRequestDto sideTransactionsRequestDto, PagingDto pagingDto) ;

    PagedDataDto getPendingTransactions( String accountNumber, PagingDto pagingDto) ;

    List<AccountTransactionInfoDto> getSourceSideTransactions(String accountNumber, long transactionId) ;

    void setAccountControlType( AccountControlCreateModelDto accountControlCreateModelDto) ;


}
