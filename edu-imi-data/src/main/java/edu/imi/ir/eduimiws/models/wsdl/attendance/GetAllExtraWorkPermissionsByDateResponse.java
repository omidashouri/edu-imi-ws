
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="GetAllExtraWorkPermissionsByDateResult" type="{http://tempuri.org/}ArrayOfDailyExtraWorkPermissionDataModel" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getAllExtraWorkPermissionsByDateResult"
})
@XmlRootElement(name = "GetAllExtraWorkPermissionsByDateResponse")
public class GetAllExtraWorkPermissionsByDateResponse {

    @XmlElement(name = "GetAllExtraWorkPermissionsByDateResult")
    protected ArrayOfDailyExtraWorkPermissionDataModel getAllExtraWorkPermissionsByDateResult;

    /**
     * Gets the value of the getAllExtraWorkPermissionsByDateResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDailyExtraWorkPermissionDataModel }
     *     
     */
    public ArrayOfDailyExtraWorkPermissionDataModel getGetAllExtraWorkPermissionsByDateResult() {
        return getAllExtraWorkPermissionsByDateResult;
    }

    /**
     * Sets the value of the getAllExtraWorkPermissionsByDateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDailyExtraWorkPermissionDataModel }
     *     
     */
    public void setGetAllExtraWorkPermissionsByDateResult(ArrayOfDailyExtraWorkPermissionDataModel value) {
        this.getAllExtraWorkPermissionsByDateResult = value;
    }

}
