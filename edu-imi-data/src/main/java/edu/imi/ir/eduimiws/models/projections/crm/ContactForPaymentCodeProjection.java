package edu.imi.ir.eduimiws.models.projections.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "contactForPaymentCodeProjection",
        types = { ContactEntity.class })
public interface ContactForPaymentCodeProjection {


    @Value("#{target.id}")
    Long getId();

    String getContactPublicId();

    @Value("#{target.nationCode}")
    String getNationCode();

    @Value("#{target.firstName}")
    String getFirstName();

    @Value("#{target.middleName}")
    String getMiddleName();

    @Value("#{target.lastName}")
    String getLastName();

    @Value("#{target.mobilePhone}")
    String getMobilePhone();

    @Value("#{target.birthdate}")
    String getBirthdate();

}
