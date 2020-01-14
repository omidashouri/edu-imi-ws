package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_CAR_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_CAR")
public class Car extends BaseEntity implements Serializable {

/*    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "car_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "car_sequence", schema = "CRM",sequenceName = "SEQ_CAR_ID",allocationSize = 1)
    private Long id;*/

    public Car() {
    }

    public Car(Long id, Long parent_id, String name, Long creatorId, String createDate, Long editorId, String editDate) {
        super(id);
        this.parent_id = parent_id;
        this.name = name;
        this.creatorId = creatorId;
        this.createDate = createDate;
        this.editorId = editorId;
        this.editDate = editDate;
    }

    @Column(name = "PARENT_ID")
    private Long parent_id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATOR_ID")
    private Long creatorId;

    @Column(name = "CREATE_DATE")
    private String createDate;

    @Column(name = "EDITOR_ID")
    private Long editorId;

    @Column(name = "EDIT_DATE")
    private String editDate;

//    OneToMany Bidirectional
//    Unidirectional does not have it
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "carId")
    private Set<CarDetail> carDetails = new HashSet<>();

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getEditorId() {
        return editorId;
    }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }


    public Set<CarDetail> getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(Set<CarDetail> carDetails) {
        this.carDetails = carDetails;
    }
}
