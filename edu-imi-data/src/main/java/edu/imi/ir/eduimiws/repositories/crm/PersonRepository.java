package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {


    @EntityGraph("personUserGraph")
    PersonEntity findByUsername(String userName);

    PersonEntity findFirstByOrderByIdDesc();

    @Query(name = "PersonEntity.findPersonUserProjectionsByIdGreaterThan", nativeQuery = true)
    List<PersonUserProjection> findPersonUserProjectionsByIdGreaterThan(@Param("personId") Long id);

    @Query(name = "PersonEntity.findAllPersonUserProjection", nativeQuery = true)
    List<PersonUserProjection> findAllPersonUserProjection();

    @Query(name = "PersonEntity.selectCurrentSequenceNumber",nativeQuery = true)
    Long selectLastSequenceNumber();

    @EntityGraph(value = "PersonEntity.findPersonSubGraphContactContactWebService",type = EntityGraph.EntityGraphType.LOAD)
    PersonEntity findByPersonApiEntity_PersonPublicId(String personPublicId);

    Page<PersonEntity> findAll(Pageable pageable);

    Page<PersonEntity> findAllByUsername(Pageable pageable,String userName);

    @EntityGraph(value = "PersonEntity.findPersonSubGraphContactContactWebService",type = EntityGraph.EntityGraphType.LOAD)
    List<PersonEntity> findPersonEntitiesByContact_NationCode(@Param("nationCode") String nationalCode);

    @EntityGraph(value = "PersonEntity.findPersonSubGraphContactContactWebService",type = EntityGraph.EntityGraphType.LOAD)
    List<PersonEntity> findAllPersonEntitiesByIdIn(List<Long> Ids);








//NU
/*    @Query(value = "Select p from PersonEntity p where p.personalCode = :username",
    countQuery = "Select count(p) from PersonEntity p where p.personalCode = :username",
    nativeQuery = false)
    PersonEntity findByUserNameQuery(@Param("username") String userName);*/

//NU
/*    @Query(value = "Select p from PersonEntity p where p.personalCode like concat('%',:username,'%') ",
            countQuery = "Select count(p) from PersonEntity p where p.personalCode like concat('%',:username,'%')",
            nativeQuery = false)
    List<PersonEntity> findAllByUserNameContaining(@Param("username") String userName);*/
//NU
//    PersonEntity findByContactId(Long contactId);
}
