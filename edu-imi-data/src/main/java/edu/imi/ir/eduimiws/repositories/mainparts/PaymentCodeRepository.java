package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.models.projections.mainparts.PaymentCodeApiProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCodeRepository extends CrudRepository<PaymentCodeApiEntity, Long> {

    Page<PaymentCodeApiEntity> findAll(Pageable pageable);

    Page<PaymentCodeApiEntity> findAllByPaymentCodeContaining(String paymentCode, Pageable pageable);

    PaymentCodeApiEntity findByPaymentCodePublicId(String paymentCodePublicId);

    @Query(name = "PaymentCodeApiEntity.queryPageablePaymentCodeApiProjection")
    Page<PaymentCodeApiProjection> queryAllPaymentCodeApiProjection(
                                        @Param("paymentCode") String paymentCode,
                                        @Param("requestDescription") String requestDescription,
                                        @Param("nationalCode") String nationalCode,
                                        @Param("expenseCode") String expenseCode,
                                        @Param("expenseTitle") String expenseTitle,
                                        @Param("projectCode") String projectCode,
                                        @Param("projectName") String projectName,
                                        @Param("payerContactMobilePhone") String payerContactMobilePhone,
                                        @Param("payerContactFullName") String payerContactFullName,
                                        @Param("accountName") String accountName,
                                        Pageable pageable);

}
