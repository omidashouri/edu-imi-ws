package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PrivilegeApiRepository extends CrudRepository<PrivilegeApiEntity, Long> {

    Collection<PrivilegeApiEntity> findAllByName(String privilegeName);
    Collection<PrivilegeApiEntity> findAllByPrivilegePublicIdIn(Collection<String> privilegePublicIds);
    Page<PrivilegeApiEntity> findAllByOrderByCreateDateTsDesc(Pageable pageable);
    PrivilegeApiEntity findByPrivilegePublicId(String rolePublicId);
}
