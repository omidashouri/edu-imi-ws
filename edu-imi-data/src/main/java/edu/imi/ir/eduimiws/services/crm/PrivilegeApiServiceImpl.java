package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PrivilegeApiServiceImpl implements PrivilegeApiService {
    @Override
    public List<PrivilegeApiEntity> getReadPrivilegesForRoles(Collection<RoleApiEntity> roles) {
        PrivilegeApiEntity readPrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("READ");
        readPrivilege.setCreateDateTs(new Timestamp(new Date().getTime()));
        readPrivilege.setRoles(roles);
        return Arrays.asList(readPrivilege);
    }

    @Override
    public List<PrivilegeApiEntity> getReadWriteUpdateDeletePatchPrivilegesForRoles(List<RoleApiEntity> roles) {
        PrivilegeApiEntity readPrivilege = new PrivilegeApiEntity();
        List<PrivilegeApiEntity> returnPrivileges = new ArrayList<>();
        readPrivilege.setName("READ");

        PrivilegeApiEntity writePrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("WRITE");

        PrivilegeApiEntity deletePrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("DELETE");

        PrivilegeApiEntity updatePrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("UPDATE");

        PrivilegeApiEntity patchPrivilege = new PrivilegeApiEntity();
        readPrivilege.setName("PATCH");

        returnPrivileges = Stream.of(readPrivilege, writePrivilege, deletePrivilege, updatePrivilege, patchPrivilege)
                .peek(p -> p.setCreateDateTs(new Timestamp(new Date().getTime())))
                .peek(p -> p.setRoles(roles))
                .collect(Collectors.toList());

        return returnPrivileges;
    }
}
