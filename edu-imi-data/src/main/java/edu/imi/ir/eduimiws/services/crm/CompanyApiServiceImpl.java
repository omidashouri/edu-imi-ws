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
        return companyApiRepository
                .findByCompanyPublicId(companyPublicId)
                .orElse(new CompanyApiEntity());
    }

    @Override
    public CompanyEntity findCompanyByCompanyPublicId(String companyPublicId) {
        return Optional
                .of(this.findByCompanyPublicId(companyPublicId))
                .filter(Objects::nonNull)
                .map(CompanyApiEntity::getCompany)
                .orElse(new CompanyEntity());
    }


}
