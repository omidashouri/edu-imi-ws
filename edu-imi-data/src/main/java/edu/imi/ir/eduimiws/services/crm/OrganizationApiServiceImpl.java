package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.OrganizationApiEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;
import edu.imi.ir.eduimiws.repositories.crm.OrganizationApiRepository;
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
public class OrganizationApiServiceImpl implements OrganizationApiService{

    OrganizationApiRepository organizationApiRepository;

    @Override
    public OrganizationApiEntity findByOrganizationPublicId(String organizationPublicId) {
        log.info("OrganizationApiService.findByOrganizationPublicId - organizationPublicId: {}", organizationPublicId);
        OrganizationApiEntity result = organizationApiRepository
                .findByOrganizationPublicId(organizationPublicId)
                .orElse(new OrganizationApiEntity());
        log.info("OrganizationApiService.findByOrganizationPublicId - result: {}", result);
        return result;
    }

    @Override
    public OrganizationEntity findOrganizationByOrganizationPublicId(String organizationPublicId) {
        log.info("OrganizationApiService.findOrganizationByOrganizationPublicId - organizationPublicId: {}", organizationPublicId);
        OrganizationEntity result = Optional
                .of(this.findByOrganizationPublicId(organizationPublicId))
                .filter(Objects::nonNull)
                .map(OrganizationApiEntity::getOrganization)
                .orElse(new OrganizationEntity());
        log.info("OrganizationApiService.findOrganizationByOrganizationPublicId - result: {}", result);
        return result;
    }
}
