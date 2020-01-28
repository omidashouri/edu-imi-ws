package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity,Long> {


    @EntityGraph("personUserGraph")
    PersonEntity findByUsername(String userName);

    @Query(value = "Select p from PersonEntity p where p.personalCode = :username",
    countQuery = "Select count(p) from PersonEntity p where p.personalCode = :username",
    nativeQuery = false)
    PersonEntity findByUserNameQuery(@Param("username") String userName);

    @Query(value = "Select p from PersonEntity p where p.personalCode like concat('%',:username,'%') ",
            countQuery = "Select count(p) from PersonEntity p where p.personalCode like concat('%',:username,'%')",
            nativeQuery = false)
    List<PersonEntity> findAllByUserNameContaining(@Param("username") String userName);

    PersonEntity findByContactId(Long contactId);
}
