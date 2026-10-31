package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ClientApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientApiRepository extends CrudRepository<ClientApiEntity, Long> {

    Page<ClientApiEntity> findAllByDeleteDateTsIsNull(Pageable pageable);

    Optional<ClientApiEntity> findByClientPublicIdAndDeleteDateTsIsNull(String clientPublicId);

    Optional<ClientApiEntity> findByClientIdAndDeleteDateTsIsNull(String clientId);

    boolean existsByClientIdAndDeleteDateTsIsNull(String clientId);

    boolean existsByPersonApi_IdAndDeleteDateTsIsNull(Long personApiId);

    boolean existsByClientIdAndDeleteDateTsIsNullAndIdNot(String clientId, Long id);

    boolean existsByPersonApi_IdAndDeleteDateTsIsNullAndIdNot(Long personApiId, Long id);

    @Query("select c from ClientApiEntity c "
            + "join fetch c.personApi p "
            + "left join fetch p.person "
            + "where c.clientId = :clientId and c.deleteDateTs is null")
    Optional<ClientApiEntity> findActiveByClientIdWithPerson(@Param("clientId") String clientId);
}
