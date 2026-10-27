package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;

import java.util.Collection;

public interface PersonRoleApiService {

    PersonApiEntity addRoles(PersonApiEntity personApi, Collection<String> rolePublicIds);

    PersonApiEntity removeRoles(PersonApiEntity personApi, Collection<String> rolePublicIds);

    PersonApiEntity replaceRoles(PersonApiEntity personApi, Collection<String> rolePublicIds);
}
