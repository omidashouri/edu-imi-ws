package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.models.request.RoleForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface RoleApiService {

    Collection<RoleApiEntity> getDefaultUserRole();

    RoleApiEntity createRoleByRoleForm(RoleForm roleForm);

    Collection<RoleApiEntity> findAllByRoleName(String roleName);

    Collection<RoleApiEntity> findAllByRoleNameAndPrivileges(String roleName,Collection<PrivilegeApiEntity> privileges);

    Page<RoleApiEntity> findAllRoleEntityPagesOrderByCreateDateDesc(Pageable pageable);

    RoleApiEntity findByRolePublicId(String rolePublicId);

    Collection<RoleApiEntity> findAllByRolePublicIdsIn(List<String> rolePublicIds);
}
