package edu.imi.ir.eduimiws.config;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.repositories.crm.PrivilegeApiRepository;
import edu.imi.ir.eduimiws.repositories.crm.RoleApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ensures privilege {@code ROLE_MANAGE_PRIVILEGE} exists and is attached to {@code ROLE_ADMIN}.
 */
//todo: delete the  api for production
@Component
@RequiredArgsConstructor
@Slf4j
public class RoleManagePrivilegeBootstrap implements ApplicationRunner {

    public static final String MANAGE_PRIVILEGE_NAME = "ROLE_MANAGE_PRIVILEGE";
    public static final String ADMIN_ROLE_NAME = "ROLE_ADMIN";

    private final PrivilegeApiRepository privilegeApiRepository;
    private final RoleApiRepository roleApiRepository;
    private final PublicIdUtil publicIdUtil;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        PrivilegeApiEntity managePrivilege = ensurePrivilege();
        Collection<RoleApiEntity> adminRoles = roleApiRepository.findAllByName(ADMIN_ROLE_NAME);
        if (adminRoles == null || adminRoles.isEmpty()) {
            log.warn("Bootstrap skipped attaching {}: role {} was not found",
                    MANAGE_PRIVILEGE_NAME, ADMIN_ROLE_NAME);
            return;
        }

        for (RoleApiEntity adminRole : adminRoles) {
            Set<PrivilegeApiEntity> privileges = adminRole.getPrivileges() == null
                    ? new HashSet<>()
                    : new HashSet<>(adminRole.getPrivileges());
            boolean alreadyAssigned = privileges.stream()
                    .anyMatch(privilege -> MANAGE_PRIVILEGE_NAME.equalsIgnoreCase(privilege.getName()));
            if (alreadyAssigned) {
                continue;
            }
            privileges.add(managePrivilege);
            adminRole.setPrivileges(privileges);
            adminRole.setEditDateTs(new Timestamp(new Date().getTime()));
            roleApiRepository.save(adminRole);
            log.info("Attached privilege {} to role {}", MANAGE_PRIVILEGE_NAME, ADMIN_ROLE_NAME);
        }
    }

    private PrivilegeApiEntity ensurePrivilege() {
        Collection<PrivilegeApiEntity> existing =
                privilegeApiRepository.findAllByName(MANAGE_PRIVILEGE_NAME);
        if (existing != null && !existing.isEmpty()) {
            return existing.iterator().next();
        }

        PrivilegeApiEntity privilege = new PrivilegeApiEntity();
        privilege.setName(MANAGE_PRIVILEGE_NAME);
        privilege.setPrivilegePublicId(publicIdUtil.generateUniquePublicId());
        privilege.setCreateDateTs(new Timestamp(new Date().getTime()));
        privilege.setDescription("Manage roles and privileges");
        PrivilegeApiEntity saved = privilegeApiRepository.save(privilege);
        log.info("Created privilege {}", MANAGE_PRIVILEGE_NAME);
        return saved;
    }
}
