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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_INTERNAL_RESPONSE_LOG_ID",
        allocationSize = 1)
@Table(schema = "CRM", name = "TBL_INTERNAL_RESPONSE_LOG")
public class InternalResponseLogEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INTERNAL_REQUEST_ID", nullable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private InternalRequestLogEntity internalRequestLog;

    @Column(name = "RESPONSE_STATUS")
    private Short responseStatus;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "RESPONSE_JSON")
    private String responseJson;

    @Column(name = "RESPONSE_TIMESTAMP", nullable = false)
    private LocalDateTime responseTimestamp;

    @PrePersist
    protected void onPersist() {
        if (responseTimestamp == null) {
            responseTimestamp = LocalDateTime.now();
        }
    }
}
