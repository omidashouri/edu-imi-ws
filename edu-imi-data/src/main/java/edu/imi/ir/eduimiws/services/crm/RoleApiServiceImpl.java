package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.exceptions.RoleServiceException;
import edu.imi.ir.eduimiws.repositories.crm.PrivilegeApiRepository;
import edu.imi.ir.eduimiws.repositories.crm.RoleApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleApiServiceImpl implements RoleApiService {

    private final RoleApiRepository roleApiRepository;
    private final PrivilegeApiRepository privilegeApiRepository;
    private final PrivilegeApiService privilegeApiService;

    @Override
    public Collection<RoleApiEntity> getDefaultUserRole() {
        RoleApiEntity userRole = new RoleApiEntity();
        userRole.setName("ROLE_USER");
        userRole.setCreateDateTs(new Timestamp(new Date().getTime()));
        return Arrays.asList(userRole);
    }

    @Override
    public RoleApiEntity createRoleByRoleName(String roleName) {

        Collection<RoleApiEntity> findRoles = this
                .findAllByRoleName((new StringBuilder()).append("ROLE_").append(roleName.toUpperCase()).toString());
        if (!findRoles.isEmpty() || findRoles.size() > 0) {
            throw new RoleServiceException("Duplicate Role Found For " + roleName);
        }

        RoleApiEntity newRole = new RoleApiEntity();
        newRole.setName("ROLE_" + roleName.trim());
        newRole.setCreateDateTs(new Timestamp(new Date().getTime()));

        Collection<PrivilegeApiEntity> newPrivileges = privilegeApiService.getFullPrivilege();

        newPrivileges.stream().forEachOrdered(np -> np.setRoles(Arrays.asList(newRole)));
        newRole.setPrivileges(newPrivileges);

//        privilegeApiRepository.saveAll(newPrivileges);
        privilegeApiService.saveAllPrivilegeApis(newPrivileges);
        RoleApiEntity savedRole = roleApiRepository.save(newRole);
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
}
