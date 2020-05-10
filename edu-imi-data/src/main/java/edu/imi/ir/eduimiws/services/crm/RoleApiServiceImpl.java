package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.exceptions.RoleServiceException;
import edu.imi.ir.eduimiws.models.request.RoleForm;
import edu.imi.ir.eduimiws.repositories.crm.PrivilegeApiRepository;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleApiServiceImpl implements RoleApiService {

    private final RoleApiRepository roleApiRepository;
    private final PrivilegeApiRepository privilegeApiRepository;
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

        String correctedRoleName = (new StringBuilder())
                .append("ROLE_")
                .append(roleForm.getRoleName().trim().toUpperCase())
                .toString();
        Collection<String> privilegePublicIds;
        Collection<PrivilegeApiEntity> privilegeApis = null;
        Collection<RoleApiEntity> duplicatedRoles;

/*        Collection<RoleApiEntity> findRoles = this
                .findAllByRoleName(correctedRoleName);
        if (!findRoles.isEmpty() || findRoles.size() > 0) {
            throw new RoleServiceException("Duplicate Role Found For " + roleForm.getRoleName());
        }*/

        RoleApiEntity newRole = new RoleApiEntity();

        if (roleForm.getPrivilegePublicId() != null) {
            privilegePublicIds = roleForm.getPrivilegePublicId();

            privilegeApis = privilegeApiService.
                    findAllByPrivilegePublicIds(privilegePublicIds.stream().collect(Collectors.toList()));

            if (privilegeApis != null && privilegeApis.size() > 0) {
                AtomicInteger duplicateFounded = new AtomicInteger();
                List<String> roleNames = privilegeApis.stream()
                        .map(PrivilegeApiEntity::getRoles)
                        .flatMap(Collection::stream)
                        .map(RoleApiEntity::getName)
                        .collect(Collectors.toList());

                if (roleNames != null && roleNames.size() == privilegeApis.size()) {
                    roleNames
                            .stream()
                            .filter(correctedRoleName::equalsIgnoreCase)
                            .findAny().ifPresent(n -> {
                        duplicateFounded.getAndIncrement();
                    });
                    if (duplicateFounded.intValue() == privilegeApis.size()) {
                        throw new RoleServiceException("Duplicate Role Found For " + roleForm.getRoleName());
                    }
                }
/*                duplicatedRoles = roleApiRepository
                        .findAllByNameAndPrivilegesIn(correctedRoleName, privilegeApis.stream().collect(Collectors.toList()));*/

                newRole.setPrivileges(privilegeApis.stream().collect(Collectors.toSet()));
            } else {
                duplicatedRoles = roleApiRepository.findAllByName(correctedRoleName);
                if (duplicatedRoles != null && duplicatedRoles.size() > 0) {

                    boolean duplicateRoleWihOutPrivilege =
                            duplicatedRoles
                                    .stream()
                                    .filter(r -> r.getPrivileges().size() == 0)
                                    .findAny()
                                    .isPresent();

                    if (duplicateRoleWihOutPrivilege) {
                        throw new RoleServiceException("Duplicate Role Found For " + roleForm.getRoleName());
                    }
                }
            }
        }


        newRole.setName(correctedRoleName);
        newRole.setCreateDateTs(new Timestamp(new Date().getTime()));
        newRole.setRolePublicId(this.generateRolePublicId());
/*        Collection<PrivilegeApiEntity> newPrivileges = privilegeApiService.getFullPrivilege();
        newPrivileges.stream().forEachOrdered(np -> np.setRoles(Arrays.asList(newRole)));
        newRole.setPrivileges(newPrivileges.stream().collect(Collectors.toSet()));
//        privilegeApiRepository.saveAll(newPrivileges);
        privilegeApiService.saveAllPrivilegeApis(newPrivileges);*/
        RoleApiEntity savedRole = roleApiRepository.save(newRole);
/*        privilegeApis
                .stream()
                .forEachOrdered(np -> np.setRoles(Arrays.asList(savedRole)));
        privilegeApiService.saveAllPrivilegeApis(privilegeApis);*/
        return savedRole;
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
