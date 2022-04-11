package edu.imi.ir.eduimiws.assemblers.crm;

import edu.imi.ir.eduimiws.controllers.crm.v1.AccountController;
import edu.imi.ir.eduimiws.mapper.crm.AccountResponseForPaymentCodeAccountDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.response.crm.AccountResponseForPaymentCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountResponseForPaymentCodeAssembler extends RepresentationModelAssemblerSupport<AccountDto, AccountResponseForPaymentCode> {

    private final AccountResponseForPaymentCodeAccountDtoMapper accountResponseForPaymentCodeAccountDtoMapper;

    public AccountResponseForPaymentCodeAssembler(AccountResponseForPaymentCodeAccountDtoMapper accountResponseForPaymentCodeAccountDtoMapper) {
        super(AccountController.class, AccountResponseForPaymentCode.class);
        this.accountResponseForPaymentCodeAccountDtoMapper = accountResponseForPaymentCodeAccountDtoMapper;
    }

    @Override
    public AccountResponseForPaymentCode toModel(AccountDto accountDto) {

        AccountResponseForPaymentCode accountResponseForPaymentCode = accountResponseForPaymentCodeAccountDtoMapper
                .accountDtoToAccountResponseForPaymentCode(accountDto);

        Pageable defaultPageable = PageRequest
                .of(0, 10, Sort.Direction.fromString("DESC"), "accountName");

        if (accountDto.getAccountPublicId() != null) {
            accountResponseForPaymentCode
                    .add(linkTo(
                            methodOn(
                                    AccountController.class)
                                    .getAccountByAccountPublicId(accountDto.getAccountPublicId()))
                            .withSelfRel());
        }

        if(accountDto.getEconomicalCode() != null){
            accountResponseForPaymentCode
                    .add(linkTo(
                            methodOn(AccountController.class)
                            .getAccountForPaymentCodeByEconomicalCode(accountDto.getEconomicalCode(), defaultPageable))
                    .withRel("economicalCode"));
        }

        return accountResponseForPaymentCode;
    }

    @Override
    public CollectionModel<AccountResponseForPaymentCode> toCollectionModel(Iterable<? extends AccountDto> accountDtos) {
        CollectionModel<AccountResponseForPaymentCode> accountResponseCollectionModel = super.toCollectionModel(accountDtos);

        Pageable defaultPageable = PageRequest
                .of(0, 10, Sort.Direction.fromString("DESC"), "accountName");

        accountResponseCollectionModel
                .add(linkTo(methodOn(AccountController.class).getAccountsForPaymentCode(defaultPageable)).withRel("forPaymentCodes"));

        return accountResponseCollectionModel;
    }

}
