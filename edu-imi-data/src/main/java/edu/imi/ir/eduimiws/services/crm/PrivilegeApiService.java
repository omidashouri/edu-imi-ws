package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface PrivilegeApiService {

    List<PrivilegeApiEntity> getReadPrivilegesForRoles(Collection<RoleApiEntity> roles);
    List<PrivilegeApiEntity> getReadWriteUpdateDeletePatchPrivilegesForRoles(List<RoleApiEntity> roles);
    Collection<PrivilegeApiEntity> getFullPrivilege();
    Collection<PrivilegeApiEntity> createFullPrivilege();
    Collection<PrivilegeApiEntity> saveAllPrivilegeApis(Collection<PrivilegeApiEntity> privilegeApis);
    PrivilegeApiEntity createPrivilegeByName(String roleName);
    Collection<PrivilegeApiEntity> findAllByPrivilegeName(String privilegeName);
    Collection<PrivilegeApiEntity> findAllByPrivilegePublicIds(List<String> privilegePublicIds);
    Page<PrivilegeApiEntity> findAllPrivilegeEntityPagesOrderByCreateDateDesc(Pageable pageable);
    PrivilegeApiEntity findByPrivilegePublicId(String privilegePublicId);
}
