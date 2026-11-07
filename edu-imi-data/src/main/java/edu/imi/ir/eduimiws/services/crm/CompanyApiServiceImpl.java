package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.CompanyApiEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.repositories.crm.CompanyApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CompanyApiServiceImpl implements CompanyApiService {

    CompanyApiRepository companyApiRepository;

    @Override
    public CompanyApiEntity findByCompanyPublicId(String companyPublicId) {
        log.info("CompanyApiService.findByCompanyPublicId - companyPublicId: {}", companyPublicId);
        CompanyApiEntity result = companyApiRepository
                .findByCompanyPublicId(companyPublicId)
                .orElse(new CompanyApiEntity());
        log.info("CompanyApiService.findByCompanyPublicId - result: {}", result);
        return result;
    }

    @Override
    public CompanyEntity findCompanyByCompanyPublicId(String companyPublicId) {
        log.info("CompanyApiService.findCompanyByCompanyPublicId - companyPublicId: {}", companyPublicId);
        CompanyEntity result = Optional
                .of(this.findByCompanyPublicId(companyPublicId))
                .filter(Objects::nonNull)
                .map(CompanyApiEntity::getCompany)
                .orElse(new CompanyEntity());
        log.info("CompanyApiService.findCompanyByCompanyPublicId - result: {}", result);
        return result;
    }


}
