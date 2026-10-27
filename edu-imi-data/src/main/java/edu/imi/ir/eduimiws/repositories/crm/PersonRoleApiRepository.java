package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRoleApiRepository extends CrudRepository<PersonRoleEntity, Long> {

    List<PersonRoleEntity> findAllByPersonApiId(Long personApiId);

    Optional<PersonRoleEntity> findByPersonApiIdAndRoleApiId(Long personApiId, Long roleApiId);

    Collection<PersonRoleEntity> findAllByPersonApiIdAndRoleApiIdIn(Long personApiId, Collection<Long> roleApiIds);

    void deleteByPersonApiIdAndRoleApiIdIn(Long personApiId, Collection<Long> roleApiIds);
}
