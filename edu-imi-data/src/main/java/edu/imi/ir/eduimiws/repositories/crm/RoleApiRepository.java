package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoleApiRepository extends CrudRepository<RoleApiEntity, Long> {

    Collection<RoleApiEntity> findAllByName(String RoleName);

    Collection<RoleApiEntity> findAllByNameAndPrivilegesIn(String roleName, List<PrivilegeApiEntity> privilegeApis);

    @Query(" from RoleApiEntity  r left join r.privileges p where r.id=8L and p.id=85L")
    List<RoleApiEntity> findByp();

}
