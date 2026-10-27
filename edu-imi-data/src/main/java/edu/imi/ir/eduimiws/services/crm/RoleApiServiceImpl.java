package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.exceptions.services.RoleServiceException;
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
        RoleApiEntity userRole = new RoleApiEntity();
        userRole.setName("ROLE_USER");
        userRole.setCreateDateTs(new Timestamp(new Date().getTime()));
        return Arrays.asList(userRole);
    }

    @Override
    public RoleApiEntity createRoleByRoleForm(RoleForm roleForm) {

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
        return roleApiRepository.save(newRole);
    }

    @Override
    public RoleApiEntity updateRoleByRoleForm(String rolePublicId, RoleForm roleForm) {
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
        return roleApiRepository.save(roleApi);
    }

    @Override
    public RoleApiEntity replacePrivileges(String rolePublicId, Collection<String> privilegePublicIds) {
        RoleApiEntity roleApi = requireRole(rolePublicId);
        if (privilegePublicIds == null) {
            throw new RoleServiceException("Privilege Public Id is Empty");
        }
        roleApi.setPrivileges(resolvePrivilegesAsSet(privilegePublicIds));
        roleApi.setEditDateTs(new Timestamp(new Date().getTime()));
        return roleApiRepository.save(roleApi);
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
        Collection<RoleApiEntity> returnedRoleApis;
        returnedRoleApis = roleApiRepository.findAllByName(roleName);
        return returnedRoleApis;
    }

    @Override
    public Collection<RoleApiEntity> findAllByRoleNameAndPrivileges(String roleName, Collection<PrivilegeApiEntity> privileges) {
        List<PrivilegeApiEntity> pa = privileges.stream().collect(Collectors.toList());
        Collection<RoleApiEntity> returnedRoles = roleApiRepository
                .findAllByNameAndPrivilegesIn(roleName, pa);
        return returnedRoles;
    }

    @Override
    public Page<RoleApiEntity> findAllRoleEntityPagesOrderByCreateDateDesc(Pageable pageable) {
        Page<RoleApiEntity> roleApiPages = roleApiRepository
                .findAllByOrderByCreateDateTsDesc(pageable);
        return roleApiPages;
    }

    @Override
    public RoleApiEntity findByRolePublicId(String rolePublicId) {
        RoleApiEntity roleApi = roleApiRepository
                .findByRolePublicId(rolePublicId);
        return roleApi;
    }

    @Override
    public Collection<RoleApiEntity> findAllByRolePublicIdsIn(List<String> rolePublicIds) {
        Collection<RoleApiEntity> returnRoles = roleApiRepository
                .findAllByRolePublicIdIn(rolePublicIds);
        return returnRoles;
    }

    private String generateRolePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
