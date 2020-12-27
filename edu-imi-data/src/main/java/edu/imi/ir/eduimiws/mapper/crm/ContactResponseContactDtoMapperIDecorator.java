package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.response.crm.ContactResponse;
import edu.imi.ir.eduimiws.services.crm.AccountService;
import org.mapstruct.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class ContactResponseContactDtoMapperIDecorator implements ContactResponseContactDtoMapperI {


    @Autowired
    @Qualifier("delegate")
    private ContactResponseContactDtoMapperI delegate;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public ContactDto toContactDto(ContactResponse contactResponse, @Context CycleAvoidingMappingContext context) {

        ContactDto contactDto = delegate.toContactDto(contactResponse, context);

        AccountDto accountDto = accountService.findAccountDtoByAccountPublicId(contactResponse.getAccountPublicId());
        contactDto.setAccountDto(accountDto);
        contactDto.setAccountId(accountDto.getId());

        return contactDto;
    }

}
