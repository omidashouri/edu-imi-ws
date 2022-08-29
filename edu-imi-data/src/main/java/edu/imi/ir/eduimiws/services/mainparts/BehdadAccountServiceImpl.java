package edu.imi.ir.eduimiws.services.mainparts;


/*import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.*;
import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidCredentialException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidDateException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidIdentifierTypeException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidPageNumberException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidPageSizeException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidTransactionTypeException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.PageSizeIsTooMuchException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.PasswordIsNotStrongException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.TooMuchAccountsException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.UnableToAuthenticateException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.UnableToGetTransactionsException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.UserTemporarilySuspendedException;*/

import edu.imi.ir.eduimiws.mapper.mainparts.behdad.ChangePasswordRequestMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.PagedDataMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.PagingMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.account.*;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.ChangePasswordRequestDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagedDataDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagingDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
@RequiredArgsConstructor
@Slf4j
public class BehdadAccountServiceImpl implements BehdadAccountService {

/*    private final AccountService accountServiceBehdad;
    private final Credential credentialAccount;*/
    private final ChangePasswordRequestMapper changePasswordRequestMapper;
    private final BalanceInfoMapper balanceInfoMapper;
    private final AccountControlCreateModelMapper accountControlCreateModelMapper;
    private final AccountTransactionInfoMapper accountTransactionInfoMapper;
    private final AccountTransactionFilterMapper accountTransactionFilterMapper;
    private final SideTransactionsRequestMapper sideTransactionsRequestMapper;
    private final PagingMapper pagingMapper;
    private final PagedDataMapper pagedDataMapper;
    private final MultipleAccountTransactionFilterMapper multipleAccountTransactionFilterMapper;

    @Override
    public List<String> getAccountNumbers() {
      /*  List<String> list = new ArrayList<>();
        try {
            return accountServiceBehdad.getAccountNumbers(credentialAccount);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        }*/
        return null;
    }

    @Override
    public void changePassword(ChangePasswordRequestDto changePasswordRequestDto) {
       /* ChangePasswordRequest changePasswordRequest = changePasswordRequestMapper
                .toChangePasswordRequest(changePasswordRequestDto);
        try {
            accountServiceBehdad.changePassword(changePasswordRequest);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToChangePasswordException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        }*/
    }

    @Override
    public void clearAccountControlType(String accountNumber, String identifierType)  {
/*        try {
            accountServiceBehdad.clearAccountControlType(credentialAccount, accountNumber, identifierType);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidIdentifierTypeException_Exception e) {
            throw new InvalidIdentifierTypeException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        }*/
    }

    @Override
    public BalanceInfoDto getAccountBalance(String accountNumber)  {
/*        BalanceInfo balanceInfo = null;
        try {
            balanceInfo = accountServiceBehdad.getAccountBalance(credentialAccount, accountNumber);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        }
        return balanceInfoMapper.toBalanceInfoDto(balanceInfo);*/
        return null;
    }

    @Override
    public String getAccountControlType(String accountNumber, String identifierType) {
        String accountControlType = null;
/*        try {
            accountControlType = accountServiceBehdad.getAccountControlType(credentialAccount, accountNumber, identifierType);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidIdentifierTypeException_Exception e) {
            throw new InvalidIdentifierTypeException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        }*/
        return accountControlType;
    }

    @Override
    public PagedDataDto getBankTransactionDetails(
            AccountTransactionFilterDto accountTransactionFilterDto,
            PagingDto pagingDto)  {
/*        AccountTransactionFilter accountTransactionFilter = accountTransactionFilterMapper.toAccountTransactionFilter(accountTransactionFilterDto);
        Paging paging = getPagingFromPagingDto(pagingDto);
        PagedData pagedData = null;
        try {
            pagedData = accountServiceBehdad.getBankTransactionsDetails(credentialAccount, accountTransactionFilter, paging);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (InvalidPageNumberException_Exception e) {
            throw new InvalidPageNumberException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidPageSizeException_Exception e) {
            throw new InvalidPageSizeException();
        } catch (UnableToGetTransactionsException_Exception e) {
            throw new UnableToGetTransactionsException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        } catch (PageSizeIsTooMuchException_Exception e) {
            throw new PageSizeIsTooMuchException();
        } catch (InvalidDateException_Exception e) {
            throw new InvalidDateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        }
        return pagedDataMapper.toPagedDataDto(pagedData);*/
        return null;
    }

    @Override
    public List<AccountTransactionInfoDto> getDestinationSideTransactions(String accountNumber, long transactionId) {
/*        List<AccountTransactionInfo> accountTransactionInfos = null;
        try {
            accountTransactionInfos = accountServiceBehdad.getDestinationSideTransactions(credentialAccount, accountNumber, transactionId);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (InvalidPageNumberException_Exception e) {
            throw new InvalidPageNumberException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidTransactionTypeException_Exception e) {
            throw new InvalidTransactionTypeException();
        } catch (InvalidPageSizeException_Exception e) {
            throw new InvalidPageSizeException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        } catch (TransactionDoesNotBelongToAccount_Exception e) {
            throw new TransactionDoesNotBelongToAccountException();
        } catch (PageSizeIsTooMuchException_Exception e) {
            throw new PageSizeIsTooMuchException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        }
        return accountTransactionInfoMapper.toAccountTransactionInfoDtos(accountTransactionInfos);*/
        return null;
    }

    @Override
    public PagedDataDto getMultipleAccountTransactionsDetails(
            MultipleAccountTransactionFilterDto multipleAccountTransactionFilterDto,
            PagingDto pagingDto)  {

/*        MultipleAccountTransactionFilter multipleAccountTransactionFilter = multipleAccountTransactionFilterMapper.toMultipleAccountTransactionFilter(multipleAccountTransactionFilterDto);
        Paging paging = getPagingFromPagingDto(pagingDto);
        PagedData pagedData = null;
        try {
            pagedData = accountServiceBehdad.getMultipleAccountTransactionsDetails(credentialAccount, multipleAccountTransactionFilter, paging);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (InvalidPageNumberException_Exception e) {
            throw new InvalidPageNumberException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidPageSizeException_Exception e) {
            throw new InvalidPageSizeException();
        } catch (UnableToGetTransactionsException_Exception e) {
            throw new UnableToGetTransactionsException();
        } catch (TooMuchAccountsException_Exception e) {
            throw new TooMuchAccountsException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        } catch (PageSizeIsTooMuchException_Exception e) {
            throw new PageSizeIsTooMuchException();
        } catch (InvalidDateException_Exception e) {
            throw new InvalidDateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        }
        return pagedDataMapper.toPagedDataDto(pagedData);*/
        return null;
    }

    @Override
    public PagedDataDto getPagedDestinationSideTransactions(
            SideTransactionsRequestDto sideTransactionsRequestDto,
            PagingDto pagingDto) {
 /*       SideTransactionsRequest sideTransactionsRequest = sideTransactionsRequestMapper.toSideTransactionsRequest(sideTransactionsRequestDto);
        Paging paging = getPagingFromPagingDto(pagingDto);
        PagedData pagedData;
        try {
            pagedData = accountServiceBehdad.getPagedDestinationSideTransactions(credentialAccount, sideTransactionsRequest, paging);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (InvalidPageNumberException_Exception e) {
            throw new InvalidPageNumberException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidTransactionTypeException_Exception e) {
            throw new InvalidTransactionTypeException();
        } catch (InvalidPageSizeException_Exception e) {
            throw new InvalidPageSizeException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        } catch (TransactionDoesNotBelongToAccount_Exception e) {
            throw new TransactionDoesNotBelongToAccountException();
        } catch (PageSizeIsTooMuchException_Exception e) {
            throw new PageSizeIsTooMuchException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        }
        return pagedDataMapper.toPagedDataDto(pagedData);*/
        return null;
    }

    @Override
    public PagedDataDto getPagedSourceSideTransactions(
            SideTransactionsRequestDto sideTransactionsRequestDto,
            PagingDto pagingDto)  {
/*        SideTransactionsRequest sideTransactionsRequest = sideTransactionsRequestMapper.toSideTransactionsRequest(sideTransactionsRequestDto);
        Paging paging = getPagingFromPagingDto(pagingDto);
        PagedData pagedData = null;
        try {
            pagedData = accountServiceBehdad.getPagedSourceSideTransactions(credentialAccount, sideTransactionsRequest, paging);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (InvalidPageNumberException_Exception e) {
            throw new InvalidPageNumberException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidTransactionTypeException_Exception e) {
            throw new InvalidTransactionTypeException();
        } catch (InvalidPageSizeException_Exception e) {
            throw new InvalidPageSizeException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        } catch (TransactionDoesNotBelongToAccount_Exception e) {
            throw new TransactionDoesNotBelongToAccountException();
        } catch (PageSizeIsTooMuchException_Exception e) {
            throw new PageSizeIsTooMuchException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        }
        return pagedDataMapper.toPagedDataDto(pagedData);*/
        return null;
    }

    @Override
    public PagedDataDto getPendingTransactions(String accountNumber, PagingDto pagingDto)  {
 /*       Paging paging = getPagingFromPagingDto(pagingDto);
        PagedData pagedData = null;
        try {
            pagedData = accountServiceBehdad.getPendingTransactions(credentialAccount, accountNumber, paging);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        }
        return pagedDataMapper.toPagedDataDto(pagedData);*/
        return null;
    }

    @Override
    public List<AccountTransactionInfoDto> getSourceSideTransactions(String accountNumber, long transactionId)  {
/*        List<AccountTransactionInfo> accountTransactionInfos = null;
        try {
            accountTransactionInfos = accountServiceBehdad
                    .getSourceSideTransactions(credentialAccount, accountNumber, transactionId);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (InvalidPageNumberException_Exception e) {
            throw new InvalidPageNumberException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (InvalidTransactionTypeException_Exception e) {
            throw new InvalidTransactionTypeException();
        } catch (InvalidPageSizeException_Exception e) {
            throw new InvalidPageSizeException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        } catch (TransactionDoesNotBelongToAccount_Exception e) {
            throw new TransactionDoesNotBelongToAccountException();
        } catch (PageSizeIsTooMuchException_Exception e) {
            throw new PageSizeIsTooMuchException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        }
        return accountTransactionInfoMapper.toAccountTransactionInfoDtos(accountTransactionInfos);*/
        return null;
    }

    @Override
    public void setAccountControlType(AccountControlCreateModelDto accountControlCreateModelDto)  {
/*        AccountControlCreateModel accountControlCreateModel = accountControlCreateModelMapper.toAccountControlCreateModel(accountControlCreateModelDto);
        try {
            accountServiceBehdad.setAccountControlType(credentialAccount, accountControlCreateModel);
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        } catch (InvalidIdentifierControlTypeException_Exception e) {
            throw new InvalidIdentifierTypeException();
        } catch (InvalidIdentifierTypeException_Exception e) {
            throw new InvalidIdentifierTypeException();
        } catch (InvalidDateException_Exception e) {
            throw new InvalidDateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        }*/
    }

/*    private Paging getPagingFromPagingDto(PagingDto pagingDto) {
        return pagingMapper.toPaging(pagingDto);
    }*/


}
