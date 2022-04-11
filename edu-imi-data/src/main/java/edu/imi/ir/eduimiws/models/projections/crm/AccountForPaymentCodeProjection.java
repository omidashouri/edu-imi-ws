package edu.imi.ir.eduimiws.models.projections.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "accountForPaymentCodeProjection",
        types = { AccountEntity.class })
public interface AccountForPaymentCodeProjection {


    @Value("#{target.id}")
    Long getId();

    String getAccountPublicId();

    @Value("#{target.economicalCode}")
    String getEconomicalCode();

    @Value("#{target.accountName}")
    String getAccountName();

    @Value("#{target.mainPhone}")
    String getMainPhone();

    @Value("#{target.otherPhone}")
    String getOtherPhone();

}
