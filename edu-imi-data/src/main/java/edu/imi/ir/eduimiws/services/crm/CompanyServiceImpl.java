package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyApiEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.mapper.crm.CompanyMapper;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyApiDto;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.helper.DefaultValues;
import edu.imi.ir.eduimiws.repositories.crm.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService{

    private final DefaultValues defaultValues;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public String getImiCompanyPublicId() {
        return defaultValues.getImiCompanyPublicId();
    }

    @Override
    public CompanyDto getImiCompanyDtoById() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(defaultValues.getImiCompanyId());
        companyDto.setCompanyPublicId(defaultValues.getImiCompanyPublicId());
        companyDto.setCompanyApiId(defaultValues.getImiCompanyApiId());
        CompanyApiDto companyApiDto = new CompanyApiDto();
        companyApiDto.setId(defaultValues.getImiCompanyApiId());
        companyDto.setCompanyApi(companyApiDto);

        return companyDto;

/*        return Optional.of(companyRepository.readById(defaultValues.getImiCompanyId()))
                .filter(Objects::nonNull)
                .map(ce-> companyMapper.toCompanyDto(ce,new CycleAvoidingMappingContext()))
                .orElse(new CompanyDto());*/
    }

    @Override
    public CompanyEntity getImiCompanyEntity() {
        CompanyEntity company = new CompanyEntity();
        company.setId(defaultValues.getImiCompanyId());
        CompanyApiEntity companyApi = new CompanyApiEntity();
        companyApi.setId(defaultValues.getImiCompanyApiId());
        companyApi.setCompanyPublicId(defaultValues.getImiCompanyPublicId());
        company.setCompanyApi(companyApi);
        return company;
    }

}
