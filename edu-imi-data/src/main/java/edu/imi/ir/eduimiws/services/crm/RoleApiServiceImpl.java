package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.exceptions.services.RoleServiceException;
import edu.imi.ir.eduimiws.models.request.RoleCreateForm;
import edu.imi.ir.eduimiws.models.request.RoleForm;
import edu.imi.ir.eduimiws.repositories.crm.RoleApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleApiServiceImpl implements RoleApiService {

    private final RoleApiRepository roleApiRepository;
    private final PrivilegeApiService privilegeApiService;
    private final PublicIdUtil publicIdUtil;

    @Override
    public Collection<RoleApiEntity> getDefaultUserRole() {
        log.info("RoleApiService.getDefaultUserRole - start");
        RoleApiEntity userRole = new RoleApiEntity();
        userRole.setName("ROLE_USER");
        userRole.setCreateDateTs(new Timestamp(new Date().getTime()));
        Collection<RoleApiEntity> result = Arrays.asList(userRole);
        log.info("RoleApiService.getDefaultUserRole - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public RoleApiEntity createRoleByRoleForm(RoleCreateForm roleForm) {
        log.info("RoleApiService.createRoleByRoleForm - roleForm: {}", roleForm);

        if (roleForm.getRoleName() == null || roleForm.getRoleName().isBlank()) {
            throw new RoleServiceException("Role name is required");
        }

        String correctedRoleName = normalizeRoleName(roleForm.getRoleName());
        Collection<RoleApiEntity> existingByName = roleApiRepository.findAllByName(correctedRoleName);
        if (existingByName != null && !existingByName.isEmpty()) {
            throw new RoleServiceException("Duplicate Role Found For " + roleForm.getRoleName());
        }

        RoleApiEntity newRole = new RoleApiEntity();
        newRole.setName(correctedRoleName);
        newRole.setCreateDateTs(new Timestamp(new Date().getTime()));
        newRole.setRolePublicId(this.generateRolePublicId());
        if (roleForm.getPrivilegePublicId() != null && !roleForm.getPrivilegePublicId().isEmpty()) {
            newRole.setPrivileges(resolvePrivilegesAsSet(roleForm.getPrivilegePublicId()));
        }
        RoleApiEntity result = roleApiRepository.save(newRole);
        log.info("RoleApiService.createRoleByRoleForm - result: {}", result);
        return result;
    }

    @Override
    public RoleApiEntity updateRoleByRoleForm(String rolePublicId, RoleForm roleForm) {
        log.info("RoleApiService.updateRoleByRoleForm - rolePublicId: {}, roleForm: {}", rolePublicId, roleForm);
        RoleApiEntity roleApi = requireRole(rolePublicId);
        if (roleForm.getRoleName() != null && !roleForm.getRoleName().isBlank()) {
            String correctedRoleName = normalizeRoleName(roleForm.getRoleName());
            Collection<RoleApiEntity> existingByName = roleApiRepository.findAllByName(correctedRoleName);
            boolean duplicate = existingByName != null && existingByName.stream()
                    .anyMatch(existing -> !Objects.equals(existing.getId(), roleApi.getId()));
            if (duplicate) {
                throw new RoleServiceException("Duplicate Role Found For " + roleForm.getRoleName());
            }
            roleApi.setName(correctedRoleName);
        }
        roleApi.setEditDateTs(new Timestamp(new Date().getTime()));
        RoleApiEntity result = roleApiRepository.save(roleApi);
        log.info("RoleApiService.updateRoleByRoleForm - result: {}", result);
        return result;
    }

    @Override
    public RoleApiEntity replacePrivileges(String rolePublicId, Collection<String> privilegePublicIds) {
        log.info("RoleApiService.replacePrivileges - rolePublicId: {}, privilegePublicIds: {}", rolePublicId, privilegePublicIds);
        RoleApiEntity roleApi = requireRole(rolePublicId);
        if (privilegePublicIds == null) {
            throw new RoleServiceException("Privilege Public Id is Empty");
        }
        roleApi.setPrivileges(resolvePrivilegesAsSet(privilegePublicIds));
        roleApi.setEditDateTs(new Timestamp(new Date().getTime()));
        RoleApiEntity result = roleApiRepository.save(roleApi);
        log.info("RoleApiService.replacePrivileges - result: {}", result);
        return result;
    }

    private RoleApiEntity requireRole(String rolePublicId) {
        RoleApiEntity roleApi = roleApiRepository.findByRolePublicId(rolePublicId);
        if (roleApi == null) {
            throw new RoleServiceException("requested role not found");
        }
        return roleApi;
    }

    private Set<PrivilegeApiEntity> resolvePrivilegesAsSet(Collection<String> privilegePublicIds) {
        List<String> publicIds = privilegePublicIds.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(id -> !id.isEmpty())
                .distinct()
                .collect(Collectors.toList());
        if (publicIds.isEmpty()) {
            return java.util.Collections.emptySet();
        }
        Collection<PrivilegeApiEntity> privilegeApis =
                privilegeApiService.findAllByPrivilegePublicIds(publicIds);
        if (privilegeApis == null || privilegeApis.size() != publicIds.size()) {
            throw new RoleServiceException("One or more privileges were not found");
        }
        return privilegeApis.stream().collect(Collectors.toSet());
    }

    private String normalizeRoleName(String roleName) {
        String trimmed = roleName.trim().toUpperCase();
        return trimmed.startsWith("ROLE_") ? trimmed : "ROLE_" + trimmed;
    }

    @Override
    public Collection<RoleApiEntity> findAllByRoleName(String roleName) {
        log.info("RoleApiService.findAllByRoleName - roleName: {}", roleName);
        Collection<RoleApiEntity> returnedRoleApis;
        returnedRoleApis = roleApiRepository.findAllByName(roleName);
        log.info("RoleApiService.findAllByRoleName - resultSize: {}", returnedRoleApis == null ? null : returnedRoleApis.size());
        return returnedRoleApis;
    }

    @Override
    public Collection<RoleApiEntity> findAllByRoleNameAndPrivileges(String roleName, Collection<PrivilegeApiEntity> privileges) {
        log.info("RoleApiService.findAllByRoleNameAndPrivileges - roleName: {}, privilegesSize: {}",
                roleName, privileges == null ? null : privileges.size());
        List<PrivilegeApiEntity> pa = privileges.stream().collect(Collectors.toList());
        Collection<RoleApiEntity> returnedRoles = roleApiRepository
                .findAllByNameAndPrivilegesIn(roleName, pa);
        log.info("RoleApiService.findAllByRoleNameAndPrivileges - resultSize: {}", returnedRoles == null ? null : returnedRoles.size());
        return returnedRoles;
    }

    @Override
    public Page<RoleApiEntity> findAllRoleEntityPagesOrderByCreateDateDesc(Pageable pageable) {
        log.info("RoleApiService.findAllRoleEntityPagesOrderByCreateDateDesc - pageable: {}", pageable);
        Page<RoleApiEntity> roleApiPages = roleApiRepository
                .findAllByOrderByCreateDateTsDesc(pageable);
        log.info("RoleApiService.findAllRoleEntityPagesOrderByCreateDateDesc - resultSize: {}, totalElements: {}",
                roleApiPages == null ? null : roleApiPages.getNumberOfElements(),
                roleApiPages == null ? null : roleApiPages.getTotalElements());
        return roleApiPages;
    }

    @Override
    public RoleApiEntity findByRolePublicId(String rolePublicId) {
        log.info("RoleApiService.findByRolePublicId - rolePublicId: {}", rolePublicId);
        RoleApiEntity roleApi = roleApiRepository
                .findByRolePublicId(rolePublicId);
        log.info("RoleApiService.findByRolePublicId - result: {}", roleApi);
        return roleApi;
    }

    @Override
    public Collection<RoleApiEntity> findAllByRolePublicIdsIn(List<String> rolePublicIds) {
        log.info("RoleApiService.findAllByRolePublicIdsIn - rolePublicIds: {}", rolePublicIds);
        Collection<RoleApiEntity> returnRoles = roleApiRepository
                .findAllByRolePublicIdIn(rolePublicIds);
        log.info("RoleApiService.findAllByRolePublicIdsIn - resultSize: {}", returnRoles == null ? null : returnRoles.size());
        return returnRoles;
    }

    private String generateRolePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
