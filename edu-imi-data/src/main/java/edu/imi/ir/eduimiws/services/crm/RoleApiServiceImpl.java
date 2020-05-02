package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
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
    PrivilegeApiService privilegeApiService;
    @Override
    public Collection<RoleApiEntity> getDefaultUserRole() {
        RoleApiEntity userRole = new RoleApiEntity();
        userRole.setName("ROLE_USER");
        userRole.setCreateDateTs(new Timestamp(new Date().getTime()));
        return Arrays.asList(userRole);
    }
}
