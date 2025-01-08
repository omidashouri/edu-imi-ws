
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetAllExtraWorkPermissionsByDateResult" type="{http://tempuri.org/}ArrayOfDailyExtraWorkPermissionDataModel" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
