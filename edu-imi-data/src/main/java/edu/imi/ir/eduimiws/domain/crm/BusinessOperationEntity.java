package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_BUSINESS_OPERATION_ID",
        allocationSize = 1)
@Table(schema = "CRM", name = "TBL_BUSINESS_OPERATION")
public class BusinessOperationEntity extends BaseEntity {

    @Column(name = "OPERATION_NAME", length = 50, nullable = false, unique = true)
    private String operationName;

    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;

    @Column(name = "CREATED_BY", length = 35)
    private String createdBy;

    @Column(name = "MODIFIED_BY", length = 35)
    private String modifiedBy;

    @Column(name = "IS_ACTIVE", precision = 1, scale = 0)
    private Long isActive;
}
