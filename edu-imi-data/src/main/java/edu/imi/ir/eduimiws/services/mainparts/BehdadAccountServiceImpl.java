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
        log.info("BehdadAccountService.getAccountNumbers - start");
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
        List<String> result = null;
        log.info("BehdadAccountService.getAccountNumbers - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public void changePassword(ChangePasswordRequestDto changePasswordRequestDto) {
        log.info("BehdadAccountService.changePassword - username: {}, password: [REDACTED], newPassword: [REDACTED]",
                changePasswordRequestDto != null ? changePasswordRequestDto.getUsername() : null);
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
        log.info("BehdadAccountService.changePassword - completed");
    }

    @Override
    public void clearAccountControlType(String accountNumber, String identifierType)  {
        log.info("BehdadAccountService.clearAccountControlType - accountNumber: {}, identifierType: {}", accountNumber, identifierType);
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
        log.info("BehdadAccountService.clearAccountControlType - completed");
    }

    @Override
    public BalanceInfoDto getAccountBalance(String accountNumber)  {
        log.info("BehdadAccountService.getAccountBalance - accountNumber: {}", accountNumber);
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
        BalanceInfoDto result = null;
        log.info("BehdadAccountService.getAccountBalance - result: {}", result);
        return result;
    }

    @Override
    public String getAccountControlType(String accountNumber, String identifierType) {
        log.info("BehdadAccountService.getAccountControlType - accountNumber: {}, identifierType: {}", accountNumber, identifierType);
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
        log.info("BehdadAccountService.getAccountControlType - result: {}", accountControlType);
        return accountControlType;
    }

    @Override
    public PagedDataDto getBankTransactionDetails(
            AccountTransactionFilterDto accountTransactionFilterDto,
            PagingDto pagingDto)  {
        log.info("BehdadAccountService.getBankTransactionDetails - accountTransactionFilterDto: {}, pagingDto: {}",
                accountTransactionFilterDto, pagingDto);
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
        PagedDataDto result = null;
        log.info("BehdadAccountService.getBankTransactionDetails - resultSize: {}, totalElements: {}",
                result == null || result.getCurrentPageData() == null ? null : result.getCurrentPageData().size(),
                result == null ? null : result.getTotalCount());
        return result;
    }

    @Override
    public List<AccountTransactionInfoDto> getDestinationSideTransactions(String accountNumber, long transactionId) {
        log.info("BehdadAccountService.getDestinationSideTransactions - accountNumber: {}, transactionId: {}", accountNumber, transactionId);
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
        List<AccountTransactionInfoDto> result = null;
        log.info("BehdadAccountService.getDestinationSideTransactions - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public PagedDataDto getMultipleAccountTransactionsDetails(
            MultipleAccountTransactionFilterDto multipleAccountTransactionFilterDto,
            PagingDto pagingDto)  {
        log.info("BehdadAccountService.getMultipleAccountTransactionsDetails - multipleAccountTransactionFilterDto: {}, pagingDto: {}",
                multipleAccountTransactionFilterDto, pagingDto);

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
        PagedDataDto result = null;
        log.info("BehdadAccountService.getMultipleAccountTransactionsDetails - resultSize: {}, totalElements: {}",
                result == null || result.getCurrentPageData() == null ? null : result.getCurrentPageData().size(),
                result == null ? null : result.getTotalCount());
        return result;
    }

    @Override
    public PagedDataDto getPagedDestinationSideTransactions(
            SideTransactionsRequestDto sideTransactionsRequestDto,
            PagingDto pagingDto) {
        log.info("BehdadAccountService.getPagedDestinationSideTransactions - sideTransactionsRequestDto: {}, pagingDto: {}",
                sideTransactionsRequestDto, pagingDto);
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
        PagedDataDto result = null;
        log.info("BehdadAccountService.getPagedDestinationSideTransactions - resultSize: {}, totalElements: {}",
                result == null || result.getCurrentPageData() == null ? null : result.getCurrentPageData().size(),
                result == null ? null : result.getTotalCount());
        return result;
    }

    @Override
    public PagedDataDto getPagedSourceSideTransactions(
            SideTransactionsRequestDto sideTransactionsRequestDto,
            PagingDto pagingDto)  {
        log.info("BehdadAccountService.getPagedSourceSideTransactions - sideTransactionsRequestDto: {}, pagingDto: {}",
                sideTransactionsRequestDto, pagingDto);
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
        PagedDataDto result = null;
        log.info("BehdadAccountService.getPagedSourceSideTransactions - resultSize: {}, totalElements: {}",
                result == null || result.getCurrentPageData() == null ? null : result.getCurrentPageData().size(),
                result == null ? null : result.getTotalCount());
        return result;
    }

    @Override
    public PagedDataDto getPendingTransactions(String accountNumber, PagingDto pagingDto)  {
        log.info("BehdadAccountService.getPendingTransactions - accountNumber: {}, pagingDto: {}", accountNumber, pagingDto);
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
        PagedDataDto result = null;
        log.info("BehdadAccountService.getPendingTransactions - resultSize: {}, totalElements: {}",
                result == null || result.getCurrentPageData() == null ? null : result.getCurrentPageData().size(),
                result == null ? null : result.getTotalCount());
        return result;
    }

    @Override
    public List<AccountTransactionInfoDto> getSourceSideTransactions(String accountNumber, long transactionId)  {
        log.info("BehdadAccountService.getSourceSideTransactions - accountNumber: {}, transactionId: {}", accountNumber, transactionId);
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
        List<AccountTransactionInfoDto> result = null;
        log.info("BehdadAccountService.getSourceSideTransactions - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public void setAccountControlType(AccountControlCreateModelDto accountControlCreateModelDto)  {
        log.info("BehdadAccountService.setAccountControlType - accountControlCreateModelDto: {}", accountControlCreateModelDto);
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
        log.info("BehdadAccountService.setAccountControlType - completed");
    }

/*    private Paging getPagingFromPagingDto(PagingDto pagingDto) {
        return pagingMapper.toPaging(pagingDto);
    }*/


}
