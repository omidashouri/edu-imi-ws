package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.exceptions.services.RoleServiceException;
import edu.imi.ir.eduimiws.repositories.crm.PrivilegeApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PrivilegeApiServiceImpl implements PrivilegeApiService {

    private final PrivilegeApiRepository privilegeApiRepository;
    private final PublicIdUtil publicIdUtil;
//    private final RoleApiRepository roleApiRepository;
//    private final PersonApiRepository personApiRepository;

    @Override
    public List<PrivilegeApiEntity> getReadPrivilegesForRoles(Collection<RoleApiEntity> roles) {
        log.info("PrivilegeApiService.getReadPrivilegesForRoles - rolesSize: {}", roles == null ? null : roles.size());
        PrivilegeApiEntity readPrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("READ");
        readPrivilege.setCreateDateTs(new Timestamp(new Date().getTime()));
//        readPrivilege.setRoles(roles);
        List<PrivilegeApiEntity> result = Arrays.asList(readPrivilege);
        log.info("PrivilegeApiService.getReadPrivilegesForRoles - resultSize: {}", result == null ? null : result.size());
        return result;

    }

    @Override
    public List<PrivilegeApiEntity> getReadWriteUpdateDeletePatchPrivilegesForRoles(List<RoleApiEntity> roles) {
        log.info("PrivilegeApiService.getReadWriteUpdateDeletePatchPrivilegesForRoles - rolesSize: {}",
                roles == null ? null : roles.size());
        PrivilegeApiEntity readPrivilege = new PrivilegeApiEntity();
        List<PrivilegeApiEntity> returnPrivileges = new ArrayList<>();
        readPrivilege.setName("READ");

        PrivilegeApiEntity writePrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("WRITE");

        PrivilegeApiEntity deletePrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("DELETE");

        PrivilegeApiEntity updatePrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("UPDATE");

        PrivilegeApiEntity patchPrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("PATCH");

        returnPrivileges = Stream.of(readPrivilege, writePrivilege, deletePrivilege, updatePrivilege, patchPrivilege)
                .peek(p -> p.setCreateDateTs(new Timestamp(new Date().getTime())))
//                .peek(p -> p.setRoles(roles))
                .collect(Collectors.toList());

        log.info("PrivilegeApiService.getReadWriteUpdateDeletePatchPrivilegesForRoles - resultSize: {}",
                returnPrivileges == null ? null : returnPrivileges.size());
        return returnPrivileges;
    }

    @Override
    public Collection<PrivilegeApiEntity> getFullPrivilege() {
        log.info("PrivilegeApiService.getFullPrivilege - start");
        List<PrivilegeApiEntity> privileges = new ArrayList<>();

        Stream.of("READ","WRITE","DELETE","UPDATE","PATCH")
                .map(p->(new StringBuilder()).append(p).append("_PRIVILEGE").toString())
                .map(String::trim)
                .map(PrivilegeApiEntity::new)
                .forEachOrdered(privileges::add);

        log.info("PrivilegeApiService.getFullPrivilege - resultSize: {}", privileges == null ? null : privileges.size());
        return privileges;
    }

    @Override
    public Collection<PrivilegeApiEntity> createFullPrivilege() {
        log.info("PrivilegeApiService.createFullPrivilege - start");
        List<PrivilegeApiEntity> privileges = new ArrayList<>();

        Stream.of("READ","WRITE","DELETE","UPDATE","PATCH")
                .map(p->(new StringBuilder()).append(p).append("_PRIVILEGE").toString())
                .map(String::trim)
                .map(PrivilegeApiEntity::new)
                .forEachOrdered(privileges::add);

//        privileges.stream().forEach(p->p.setRoles(new ArrayList<>()));

        privilegeApiRepository.saveAll(privileges);

        Iterable<PrivilegeApiEntity> savedIterablePersonWebService =
                privilegeApiRepository.saveAll(privileges);

        Collection<PrivilegeApiEntity> savedPrivileges = StreamSupport
                .stream(savedIterablePersonWebService.spliterator(), false)
                .collect(Collectors.toCollection(ArrayList::new));

        log.info("PrivilegeApiService.createFullPrivilege - resultSize: {}",
                savedPrivileges == null ? null : savedPrivileges.size());
        return savedPrivileges;
    }

    @Override
    public Collection<PrivilegeApiEntity> saveAllPrivilegeApis(Collection<PrivilegeApiEntity> privilegeApis) {
        log.info("PrivilegeApiService.saveAllPrivilegeApis - privilegeApisSize: {}",
                privilegeApis == null ? null : privilegeApis.size());
        Iterable<PrivilegeApiEntity> savedIterablePersonWebService =
                privilegeApiRepository.saveAll(privilegeApis);

        Collection<PrivilegeApiEntity> savedPrivileges = StreamSupport
                .stream(savedIterablePersonWebService.spliterator(), false)
                .collect(Collectors.toCollection(ArrayList::new));
        log.info("PrivilegeApiService.saveAllPrivilegeApis - resultSize: {}",
                savedPrivileges == null ? null : savedPrivileges.size());
        return savedPrivileges;
    }

    @Override
    public PrivilegeApiEntity createPrivilegeByName(String privilegeName) {
        log.info("PrivilegeApiService.createPrivilegeByName - privilegeName: {}", privilegeName);
        if (privilegeName == null || privilegeName.isBlank()) {
            throw new RoleServiceException("Privilege name is required");
        }

        String correctedPrivilegeName = normalizePrivilegeName(privilegeName);

        Collection<PrivilegeApiEntity> findPrivileges = this
                .findAllByPrivilegeName(correctedPrivilegeName);
        if (!findPrivileges.isEmpty()) {
            throw new RoleServiceException("Duplicate Privilege Found For " + privilegeName);
        }

        PrivilegeApiEntity newPrivilege = new PrivilegeApiEntity();
        newPrivilege.setName(correctedPrivilegeName);
        newPrivilege.setPrivilegePublicId(generatePrivilegePublicId());
        newPrivilege.setCreateDateTs(new Timestamp(new Date().getTime()));

        PrivilegeApiEntity result = privilegeApiRepository.save(newPrivilege);
        log.info("PrivilegeApiService.createPrivilegeByName - result: {}", result);
        return result;
    }

    @Override
    public PrivilegeApiEntity updatePrivilegeByName(String privilegePublicId, String privilegeName) {
        log.info("PrivilegeApiService.updatePrivilegeByName - privilegePublicId: {}, privilegeName: {}",
                privilegePublicId, privilegeName);
        PrivilegeApiEntity privilegeApi = privilegeApiRepository.findByPrivilegePublicId(privilegePublicId);
        if (privilegeApi == null) {
            throw new RoleServiceException("requested privilege not found");
        }
        if (privilegeName == null || privilegeName.isBlank()) {
            throw new RoleServiceException("Privilege name is required");
        }

        String correctedPrivilegeName = normalizePrivilegeName(privilegeName);
        Collection<PrivilegeApiEntity> findPrivileges = this.findAllByPrivilegeName(correctedPrivilegeName);
        boolean duplicate = findPrivileges != null && findPrivileges.stream()
                .anyMatch(existing -> !existing.getId().equals(privilegeApi.getId()));
        if (duplicate) {
            throw new RoleServiceException("Duplicate Privilege Found For " + privilegeName);
        }

        privilegeApi.setName(correctedPrivilegeName);
        privilegeApi.setEditDateTs(new Timestamp(new Date().getTime()));
        PrivilegeApiEntity result = privilegeApiRepository.save(privilegeApi);
        log.info("PrivilegeApiService.updatePrivilegeByName - result: {}", result);
        return result;
    }

    private String normalizePrivilegeName(String privilegeName) {
        String trimmed = privilegeName.trim().toUpperCase();
        return trimmed.endsWith("_PRIVILEGE") ? trimmed : trimmed + "_PRIVILEGE";
    }

    @Override
    public Collection<PrivilegeApiEntity> findAllByPrivilegeName(String privilegeName) {
        log.info("PrivilegeApiService.findAllByPrivilegeName - privilegeName: {}", privilegeName);
        Collection<PrivilegeApiEntity> findPrivileges = privilegeApiRepository
                .findAllByName(privilegeName);
        log.info("PrivilegeApiService.findAllByPrivilegeName - resultSize: {}",
                findPrivileges == null ? null : findPrivileges.size());
        return findPrivileges;
    }

    @Override
    public Collection<PrivilegeApiEntity> findAllByPrivilegePublicIds(List<String> privilegePublicIds) {
        log.info("PrivilegeApiService.findAllByPrivilegePublicIds - privilegePublicIds: {}", privilegePublicIds);
        Collection<PrivilegeApiEntity> privilegeApis = privilegeApiRepository.findAllByPrivilegePublicIdIn(privilegePublicIds);
        log.info("PrivilegeApiService.findAllByPrivilegePublicIds - resultSize: {}",
                privilegeApis == null ? null : privilegeApis.size());
        return privilegeApis;
    }

    @Override
    public Page<PrivilegeApiEntity> findAllPrivilegeEntityPagesOrderByCreateDateDesc(Pageable pageable) {
        log.info("PrivilegeApiService.findAllPrivilegeEntityPagesOrderByCreateDateDesc - pageable: {}", pageable);
        Page<PrivilegeApiEntity> privilegeApiPages = privilegeApiRepository
                .findAllByOrderByCreateDateTsDesc(pageable);
        log.info("PrivilegeApiService.findAllPrivilegeEntityPagesOrderByCreateDateDesc - resultSize: {}, totalElements: {}",
                privilegeApiPages == null ? null : privilegeApiPages.getNumberOfElements(),
                privilegeApiPages == null ? null : privilegeApiPages.getTotalElements());
        return privilegeApiPages;
    }

    @Override
    public PrivilegeApiEntity findByPrivilegePublicId(String privilegePublicId) {
        log.info("PrivilegeApiService.findByPrivilegePublicId - privilegePublicId: {}", privilegePublicId);
        PrivilegeApiEntity privilegeApi = privilegeApiRepository
                .findByPrivilegePublicId(privilegePublicId);
        log.info("PrivilegeApiService.findByPrivilegePublicId - result: {}", privilegeApi);
        return privilegeApi;
    }

    private String generatePrivilegePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }
}
