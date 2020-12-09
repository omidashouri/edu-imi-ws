package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "ParameterEntity.findByParameterApi",
                attributeNodes = {
                        @NamedAttributeNode(value = "parameterApi")
                }
        )
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_PARAMETER_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_PARAMETER")
public class ParameterEntity extends BaseEntity {

    @Column(name = "PARAM_NAME")
    private String paramName;

    @Column(name = "PARAM_VALUE")
    private String paramValue;

    @OneToOne(optional = true)
    @JoinColumn(name = "MAIN_PARAM_ID")
    private ParameterEntity mainParam;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "parameter", fetch = FetchType.LAZY)
    private ParameterApiEntity parameterApi;

}
