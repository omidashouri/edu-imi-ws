
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
 *         &lt;element name="GetListOfEmployeeEventsResult" type="{http://tempuri.org/}ArrayOfEmployeeDataModel" minOccurs="0"/&gt;
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
    "getListOfEmployeeEventsResult"
})
@XmlRootElement(name = "GetListOfEmployeeEventsResponse")
public class GetListOfEmployeeEventsResponse {

    @XmlElement(name = "GetListOfEmployeeEventsResult")
    protected ArrayOfEmployeeDataModel getListOfEmployeeEventsResult;

    /**
     * Gets the value of the getListOfEmployeeEventsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public ArrayOfEmployeeDataModel getGetListOfEmployeeEventsResult() {
        return getListOfEmployeeEventsResult;
    }

    /**
     * Sets the value of the getListOfEmployeeEventsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public void setGetListOfEmployeeEventsResult(ArrayOfEmployeeDataModel value) {
        this.getListOfEmployeeEventsResult = value;
    }

}
