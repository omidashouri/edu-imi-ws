package edu.imi.ir.eduimiws.domain.mainparts;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_PAYMENT_CODE_API", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_PAYMENT_CODE_API")
public class PaymentCodeApiEntity extends BaseEntity {

    @Column(name = "PAYMENT_CODE_PUBLIC_ID",length = 500)
    private String paymentCodePublicId;

    @Column(name = "payment_code",length = 34)
    private String paymentCode;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "REQUEST_ID")
    private Long requestId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

    @Column(name = "DESCRIPTION",length = 500)
    private String description;

    @Column(name = "REQUEST_IP",length = 500)
    private String requestIp;

    @Column(name = "REQUEST_DESCRIPTION",length = 500)
    private String requestDescription;
}
