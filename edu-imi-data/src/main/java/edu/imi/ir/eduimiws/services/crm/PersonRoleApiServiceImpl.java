package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.exceptions.services.RoleServiceException;
import edu.imi.ir.eduimiws.repositories.crm.PersonApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PersonRoleApiServiceImpl implements PersonRoleApiService {

    private final PersonApiRepository personApiRepository;
    private final RoleApiService roleApiService;

    @Override
    public PersonApiEntity addRoles(PersonApiEntity personApi, Collection<String> rolePublicIds) {
        Collection<RoleApiEntity> rolesToAdd = resolveRoles(rolePublicIds);
        Map<Long, RoleApiEntity> merged = toRoleMap(personApi.getRoles());
        rolesToAdd.forEach(role -> merged.put(role.getId(), role));
        personApi.setRoles(new ArrayList<>(merged.values()));
        return personApiRepository.save(personApi);
    }

    @Override
    public PersonApiEntity removeRoles(PersonApiEntity personApi, Collection<String> rolePublicIds) {
        Collection<RoleApiEntity> rolesToRemove = resolveRoles(rolePublicIds);
        Set<Long> removeIds = rolesToRemove.stream()
                .map(RoleApiEntity::getId)
                .collect(Collectors.toSet());

        Collection<RoleApiEntity> remaining = toRoleMap(personApi.getRoles()).values().stream()
                .filter(role -> !removeIds.contains(role.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
        personApi.setRoles(remaining);
        return personApiRepository.save(personApi);
    }

    @Override
    public PersonApiEntity replaceRoles(PersonApiEntity personApi, Collection<String> rolePublicIds) {
        Collection<RoleApiEntity> newRoles = resolveRoles(rolePublicIds);
        personApi.setRoles(new ArrayList<>(newRoles));
        return personApiRepository.save(personApi);
    }

    private Collection<RoleApiEntity> resolveRoles(Collection<String> rolePublicIds) {
        if (rolePublicIds == null || rolePublicIds.isEmpty()) {
            throw new RoleServiceException("Role Public Id is Empty");
        }
        List<String> publicIds = rolePublicIds.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(id -> !id.isEmpty())
                .distinct()
                .collect(Collectors.toList());
        if (publicIds.isEmpty()) {
            throw new RoleServiceException("Role Public Id is Empty");
        }

        Collection<RoleApiEntity> found = roleApiService.findAllByRolePublicIdsIn(publicIds);
        if (found == null || found.size() != publicIds.size()) {
            throw new RoleServiceException("One or more roles were not found");
        }
        return found;
    }

    private Map<Long, RoleApiEntity> toRoleMap(Collection<RoleApiEntity> roles) {
        Map<Long, RoleApiEntity> map = new LinkedHashMap<>();
        if (roles != null) {
            roles.stream()
                    .filter(Objects::nonNull)
                    .filter(role -> role.getId() != null)
                    .forEach(role -> map.put(role.getId(), role));
        }
        return map;
    }
}
