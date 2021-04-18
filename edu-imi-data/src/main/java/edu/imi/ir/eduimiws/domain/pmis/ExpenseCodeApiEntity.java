package edu.imi.ir.eduimiws.domain.pmis;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "PMIS", sequenceName = "SEQ_EXPENSE_CODE_API", allocationSize = 1)
@Table(schema = "PMIS", name = "TBL_EXPENSE_CODE_API")
public class ExpenseCodeApiEntity extends BaseEntity {


    @Column(name = "EXPENSE_CODE")
    private Long expenseCode;

    @Column(name = "EXPENSE_TITLE", length = 500)
    private String expenseTitle;

    @Column(name = "EXPENSE_CODE_PUBLIC_ID", length = 500)
    private String expenseCodePublicId;

    @Column(name = "STATUS")
    private Number status;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR_ID")
    private PersonEntity editor;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;
}
