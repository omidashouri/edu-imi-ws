package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfoCommerceDto implements Serializable {

    private static final long serialVersionUID = 3235118290673349788L;

    private String filterRequester;

    private String filterPlace;

    private String filterCity;

    private String filterRequnit;

}
