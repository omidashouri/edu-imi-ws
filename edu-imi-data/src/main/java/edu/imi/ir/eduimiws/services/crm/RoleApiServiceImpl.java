package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.repositories.crm.RoleApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleApiServiceImpl implements RoleApiService {

    private final RoleApiRepository roleApiRepository;
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

        //      omiddo:  check if roleName is not in Role table generate privileges and rules

        RoleApiEntity newRole = new RoleApiEntity();
        newRole.setName("ROLE_" + roleName.trim());
        newRole.setCreateDateTs(new Timestamp(new Date().getTime()));

        Collection<PrivilegeApiEntity> newPrivileges = privilegeApiService.createFullPrivilege();

        newPrivileges.stream().forEachOrdered(np -> np.setRoles(Arrays.asList(newRole)));
        newRole.setPrivileges(newPrivileges);

        RoleApiEntity savedRole = roleApiRepository.save(newRole);
        return savedRole;
    }
}
