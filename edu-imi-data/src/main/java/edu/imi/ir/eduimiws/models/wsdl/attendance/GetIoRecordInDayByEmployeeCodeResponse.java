
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
 *         &lt;element name="GetIoRecordInDayByEmployeeCodeResult" type="{http://tempuri.org/}ArrayOfStaffIOs" minOccurs="0"/&gt;
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
    "getIoRecordInDayByEmployeeCodeResult"
})
@XmlRootElement(name = "GetIoRecordInDayByEmployeeCodeResponse")
public class GetIoRecordInDayByEmployeeCodeResponse {

    @XmlElement(name = "GetIoRecordInDayByEmployeeCodeResult")
    protected ArrayOfStaffIOs getIoRecordInDayByEmployeeCodeResult;

    /**
     * Gets the value of the getIoRecordInDayByEmployeeCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStaffIOs }
     *     
     */
    public ArrayOfStaffIOs getGetIoRecordInDayByEmployeeCodeResult() {
        return getIoRecordInDayByEmployeeCodeResult;
    }

    /**
     * Sets the value of the getIoRecordInDayByEmployeeCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStaffIOs }
     *     
     */
    public void setGetIoRecordInDayByEmployeeCodeResult(ArrayOfStaffIOs value) {
        this.getIoRecordInDayByEmployeeCodeResult = value;
    }

}
