package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCertificateSmsApiEntity;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodCertificateSmsApiProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.QueryHint;
import java.util.List;


@Repository
public interface PeriodCertificateSmsApiRepository extends CrudRepository<PeriodCertificateSmsApiEntity, Long> {


    @Query(name = "PeriodCertificateSmsApiEntity.queryByPeriodCertificateSmsApi")
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    List<PeriodCertificateSmsApiProjection> queryByPeriodCertificateSmsApi(@Param("periodCertificateActivityStatus") Long periodCertificateActivityStatus,
                                                                           @Param("registerFinalStatus") String registerFinalStatus,
                                                                           @Param("registerType") String registerType,
                                                                           @Param("registerFinancialStatus") Long registerFinancialStatus);

}
