package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_EVENT_RAISE_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_EVENT_RAISE")
public class EventRaiseEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID")
    private EventEntity eventEntity;

    @Column(name = "SECTION_ID")
    private Long sectionId;

    @Column(name = "EVENT", length = 4000)
    private String event;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @Column(name = "CREATE_TIME", length = 8)
    private String createTime;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name = "SECTION_NAME", length = 300)
    private String sectionName;

    @Column(name = "EVENT_TEXT", length = 1000)
    private String eventText;

    @Column(name = "USER_IP", length = 50)
    private String userIp;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "eventRaise", fetch = FetchType.LAZY)
    private EventRaiseApiEntity eventRaiseApi;
}
