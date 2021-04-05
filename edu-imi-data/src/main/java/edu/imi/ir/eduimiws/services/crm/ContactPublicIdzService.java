package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.AccountMapper;
import edu.imi.ir.eduimiws.mapper.crm.CompanyMapper;
import edu.imi.ir.eduimiws.mapper.crm.OrganizationMapper;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.dto.crm.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ContactPublicIdzService {

    @Autowired
    ContactApiService contactApiService;

    @Autowired
    AccountApiService accountApiService;

    @Autowired
    CompanyApiService companyApiService;

    @Autowired
    OrganizationApiService organizationApiService;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    OrganizationMapper organizationMapper;

    public Long findContactIdByContactPublicId(String contactPublicId) {
        return contactApiService.findContactIdByContactPublicId(contactPublicId);
    }

    public ContactEntity findContactByContactPublicId(String contactPublicId) {
        return contactApiService.findContactByContactPublicId(contactPublicId);
    }

/*    public Long findAccountIdByAccountPublicId(String accountPublicId){
        return accountApiService.findAccountIdByAccountPublicId(accountPublicId);
    }*/

    public AccountEntity findAccountByAccountPublicId(String accountPublicId){
        return accountApiService.findAccountByAccountPublicId(accountPublicId);
    }

    public AccountDto findAccountDtoByAccountPublicId(String accountPublicId){
        return Optional
                .of(this.findAccountByAccountPublicId(accountPublicId))
                .filter(Objects::nonNull)
                .map(a->accountMapper.toAccountDto(a,new CycleAvoidingMappingContext()))
                .orElse(null);
    }

    public CompanyEntity findCompanyByCompanyPublicId(String companyPublicId){
        return companyApiService.findCompanyByCompanyPublicId(companyPublicId);
    }

    public CompanyDto findCompanyDtoByCompanyPublicId(String companyPublicId){
        return Optional
                .of(this.findCompanyByCompanyPublicId(companyPublicId))
                .filter(Objects::nonNull)
                .map(a->companyMapper.toCompanyDto(a,new CycleAvoidingMappingContext()))
                .orElse(null);
    }

    public OrganizationEntity findOrganizationByOrganizationPublicId(String organizationPublicId){
        return organizationApiService.findOrganizationByOrganizationPublicId(organizationPublicId);
    }

    public OrganizationDto findOrganizationDtoByOrganizationPublicId(String organizationPublicId){
        return Optional
                .of(this.findOrganizationByOrganizationPublicId(organizationPublicId))
                .filter(Objects::nonNull)
                .map(a->organizationMapper.toOrganizationDto(a,new CycleAvoidingMappingContext()))
                .orElse(null);
    }

}
