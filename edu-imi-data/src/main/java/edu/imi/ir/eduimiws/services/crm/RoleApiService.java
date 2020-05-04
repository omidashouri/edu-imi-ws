package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;

import java.util.Collection;

public interface RoleApiService {

    Collection<RoleApiEntity> getDefaultUserRole();

    RoleApiEntity createRoleByRoleName(String roleName);

    Collection<RoleApiEntity> findAllByRoleName(String roleName);

    Collection<RoleApiEntity> findAllByRoleNameAndPrivileges(String roleName,Collection<PrivilegeApiEntity> privileges);
}
