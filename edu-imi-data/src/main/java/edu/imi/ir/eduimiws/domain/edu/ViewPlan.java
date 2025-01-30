package edu.imi.ir.eduimiws.domain.edu;

import lombok.*;
import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Immutable
@Table(schema = "EDU", name="TBL_PLAN")
public class ViewPlan implements Serializable {

    private static final long serialVersionUID = -3801079019195480197L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="PLAN_NO",length = 30)
    private String planNo;

    @Column(name="START_DATE",length = 10)
    private String startDate;

    @Column(name="SUBJECT",length = 500)
    private String subject;

    @Column(name="COST")
    private Long cost;

    @Column(name="CREATOR")
    private Long creator;

    @Column(name="CREATE_DATE",length = 10)
    private String createDAte;

    @Column(name="EDITOR")
    private Long editor;

    @Column(name="EDIT_DATE",length = 10)
    private String editDate;

    @Column(name="COMPANY_ID")
    private Long companyId;

    @Column(name="TYPE_ID")
    private Long TypeId;

    @Column(name="END_DATE",length = 10)
    private String endDate;

    @Column(name="CREDIT")
    private Long credit;

}
