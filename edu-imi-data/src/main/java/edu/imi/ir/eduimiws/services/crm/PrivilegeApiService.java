package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;

import java.util.Collection;
import java.util.List;

public interface PrivilegeApiService {

    List<PrivilegeApiEntity> getReadPrivilegesForRoles(Collection<RoleApiEntity> roles);
    List<PrivilegeApiEntity> getReadWriteUpdateDeletePatchPrivilegesForRoles(List<RoleApiEntity> roles);
}
