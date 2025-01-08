
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMissionRegistrationDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMissionRegistrationDataModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MissionRegistrationDataModel" type="{http://tempuri.org/}MissionRegistrationDataModel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMissionRegistrationDataModel", propOrder = {
    "missionRegistrationDataModel"
})
public class ArrayOfMissionRegistrationDataModel {

    @XmlElement(name = "MissionRegistrationDataModel", nillable = true)
    protected List<MissionRegistrationDataModel> missionRegistrationDataModel;

    /**
     * Gets the value of the missionRegistrationDataModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the missionRegistrationDataModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMissionRegistrationDataModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MissionRegistrationDataModel }
     * 
     * 
     */
    public List<MissionRegistrationDataModel> getMissionRegistrationDataModel() {
        if (missionRegistrationDataModel == null) {
            missionRegistrationDataModel = new ArrayList<MissionRegistrationDataModel>();
        }
        return this.missionRegistrationDataModel;
    }

}
