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
        log.info("CompanyService.getImiCompanyPublicId - start");
        String result = defaultValues.getImiCompanyPublicId();
        log.info("CompanyService.getImiCompanyPublicId - result: {}", result);
        return result;
    }

    @Override
    public CompanyDto getImiCompanyDtoById() {
        log.info("CompanyService.getImiCompanyDtoById - start");
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(defaultValues.getImiCompanyId());
        companyDto.setCompanyPublicId(defaultValues.getImiCompanyPublicId());
        companyDto.setCompanyApiId(defaultValues.getImiCompanyApiId());
        CompanyApiDto companyApiDto = new CompanyApiDto();
        companyApiDto.setId(defaultValues.getImiCompanyApiId());
        companyDto.setCompanyApi(companyApiDto);

        log.info("CompanyService.getImiCompanyDtoById - result: {}", companyDto);
        return companyDto;
    }

    @Override
    public CompanyEntity getImiCompanyEntity() {
        log.info("CompanyService.getImiCompanyEntity - start");
        CompanyEntity company = new CompanyEntity();
        company.setId(defaultValues.getImiCompanyId());
        CompanyApiEntity companyApi = new CompanyApiEntity();
        companyApi.setId(defaultValues.getImiCompanyApiId());
        companyApi.setCompanyPublicId(defaultValues.getImiCompanyPublicId());
        company.setCompanyApi(companyApi);
        log.info("CompanyService.getImiCompanyEntity - result: {}", company);
        return company;
    }

}
