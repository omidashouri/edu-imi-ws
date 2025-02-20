
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMissionRegistrationDataModel complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfMissionRegistrationDataModel">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="MissionRegistrationDataModel" type="{http://tempuri.org/}MissionRegistrationDataModel" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
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
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the missionRegistrationDataModel property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getMissionRegistrationDataModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MissionRegistrationDataModel }
     * </p>
     * 
     * 
     * @return
     *     The value of the missionRegistrationDataModel property.
     */
    public List<MissionRegistrationDataModel> getMissionRegistrationDataModel() {
        if (missionRegistrationDataModel == null) {
            missionRegistrationDataModel = new ArrayList<>();
        }
        return this.missionRegistrationDataModel;
    }

}
