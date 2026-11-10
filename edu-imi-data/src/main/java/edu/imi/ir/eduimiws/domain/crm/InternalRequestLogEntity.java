package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_INTERNAL_REQUEST_LOG_ID",
        allocationSize = 1)
@Table(
        schema = "CRM",
        name = "TBL_INTERNAL_REQUEST_LOG",
        uniqueConstraints = @UniqueConstraint(name = "UK_INTERNAL_REQUEST_LOG_REQUEST_ID",
                columnNames = "REQUEST_ID")
)
public class InternalRequestLogEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_OPERATION_ID", nullable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BusinessOperationEntity businessOperation;

    @Column(name = "REQUEST_URL", length = 1000, nullable = false)
    private String requestUrl;

    @Column(name = "HTTP_METHOD", length = 10, nullable = false)
    private String httpMethod;

    @Column(name = "QUERY_STRING", length = 2000)
    private String queryString;

    @Column(name = "REQUEST_ID", length = 36, nullable = false, unique = true)
    private String requestId;

    @Column(name = "OPERATOR_ID", length = 8)
    private String operatorId;

    @Column(name = "IP_ADDRESS", length = 45)
    private String ipAddress;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "REQUEST_JSON")
    private String requestJson;

    @Column(name = "REQUEST_TIMESTAMP", nullable = false)
    private LocalDateTime requestTimestamp;

    @PrePersist
    protected void onPersist() {
        if (requestTimestamp == null) {
            requestTimestamp = LocalDateTime.now();
        }
    }
}
