package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_CAR_DETAIL_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_CAR_DETAIL")
public class CarDetail extends BaseEntity {


/*    Unidirectional OneToMany, Just this side
      Bidirectional  OneToMany, syntax same above but have other side*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID", nullable = false)
    private Car carId;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "PLATE_NUM")
    private String plateNum;

    @Column(name = "PLATE_KIND")
    private String plateKing;

    @Column(name = "CREATOR_ID")
    private Long creatorId;

    @Column(name = "CREATE_DATE")
    private String createDate;

    @Column(name = "EDITOR_ID")
    private Long editorId;

    @Column(name = "EDIT_DATE")
    private String editDate;


    @Column(name = "CAR_OWNER_ID")
    private Long carOwnerId;

    @Column(name = "PARKING_CAPACITY_ID")
    private Long parkingCapacityId;


    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getPlateKing() {
        return plateKing;
    }

    public void setPlateKing(String plateKing) {
        this.plateKing = plateKing;
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

    public Long getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(Long carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    public Long getParkingCapacityId() {
        return parkingCapacityId;
    }

    public void setParkingCapacityId(Long parkingCapacityId) {
        this.parkingCapacityId = parkingCapacityId;
    }
}
