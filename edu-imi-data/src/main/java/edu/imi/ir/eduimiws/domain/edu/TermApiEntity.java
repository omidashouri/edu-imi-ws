package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_TERM_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_TERM_API")
public class TermApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "TERM_ID")
    private TermEntity term;

    @Column(name = "TERM_PUBLIC_ID", length = 500)
    private String termPublicId;

    @Column(name = "TERM_EDIT_DATE", length = 10)
    private String termEditDate;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

}
