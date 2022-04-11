package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactApiDto implements Serializable {

    private static final long serialVersionUID = 7393361902026892471L;

    private Long id;
    private String contactPublicId;

    private Long ContactId;
    private ContactDto contactDto;

    private Long creatorId;
    private String creatorPublicId;
    private PersonDto creatorDto;

    private Timestamp createDateTs;

    private Long editorId;
    private String editorPublicId;
    private PersonDto editorDto;

    private Timestamp editDateTs;

    private String contactEditDate;

    private Long companyId;
    private String companyPublicId;
    private CompanyDto companyDto;

    private Long accountId;
    private String accountPublicId;
    private AccountDto accountDto;

    private Long organizationId;
    private String organizationPublicId;
    private OrganizationDto organizationDto;

    private Long countryId;
    private String countryPublicId;
    private ParameterDto countryDto;

    private Long stateId;
    private String statePublicId;
    private ParameterDto stateDto;

    private Long cityId;
    private String cityPublicId;
    private ParameterDto cityDto;

    private Long birthCityId;
    private String birthCityPublicId;
    private ParameterDto birthCityDto;

    private Long religionId;
    private String religionPublicId;
    private ParameterDto religionDto;

    private Long eduLevelId;
    private String eduLevelPublicId;
    private ParameterDto eduLevelDto;

    private Long militaryServiceId;
    private String militaryServicePublicId;
    private ParameterDto militaryServiceDto;

}
