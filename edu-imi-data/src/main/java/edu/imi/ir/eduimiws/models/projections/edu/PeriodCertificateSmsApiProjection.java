package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCertificateSmsApiEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "periodCertificateSmsApiProjection",
        types = {PeriodCertificateSmsApiEntity.class})
public interface PeriodCertificateSmsApiProjection {

    Long getPcsaId();

    String getFullName();

    String getPhone();

    String getFieldName();

    String getPeriodName();

//    @Value("#{target.periodCertificateActivityStatus}")
    Long getActivityStatus();

//    @Value("#{target.periodCertificateDeliveryDate}")
    String getDeliveryDate();

//    @Value("#{target.registerFinancialStatus}")
    Long getFinancialStatus();

//    @Value("#{target.registerFinalStatus}")
    String getFinalStatus();

    @Value("#{target.registerType}")
    String getRegisterType();


}
