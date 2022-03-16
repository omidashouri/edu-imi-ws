package edu.imi.ir.eduimiws.models.projections.mainparts;


import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(name = "paymentCodeApiProjection",
        types = { PaymentCodeApiEntity.class })
public interface PaymentCodeApiProjection {

    @Value("#{target.paymentCode}")
     String getPaymentCode();

    @Value("#{target.paymentCodePublicId}")
     String getPaymentCodePublicId();

    @Value("#{target.createDateTs}")
     Timestamp getCreateDateTs();

    @Value("#{target.editDateTs}")
     Timestamp getEditDateTs();

    @Value("#{target.deleteDateTs}")
     Timestamp getDeleteDateTs();

     String getCreatorPublicId();

    @Value("#{target.description}")
     String getDescription();

    @Value("#{target.requestIp}")
     String getRequestIp();

    @Value("#{target.requestDescription}")
     String getRequestDescription();

    @Value("#{target.nationalCode}")
     String getNationalCode();

     String getExpenseCodePublicId();

    @Value("#{target.expenseCode}")
     Long getExpenseCode();

     String getExpenseTitle();

     String getProjectPublicId();

     @Value("#{target.projectCode}")
     String getProjectCode();

     String getProjectName();

     String getBankApiPublicId();

    @Value("#{target.requestCode}")
     Long getRequestCode();

     String getPayerUserPublicId();

     String getPayerContactPublicId();

     String getPayerContactMobilePhone();

     String getPayerContactFullName();

    String getAccountName();

    String getAccountPublicId();
}
