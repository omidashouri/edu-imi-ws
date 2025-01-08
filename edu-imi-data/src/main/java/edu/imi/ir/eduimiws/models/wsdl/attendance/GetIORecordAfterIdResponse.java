
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
 *         &lt;element name="GetIORecordAfterIdResult" type="{http://tempuri.org/}ArrayOfIoRecordDataModel" minOccurs="0"/&gt;
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
    "getIORecordAfterIdResult"
})
@XmlRootElement(name = "GetIORecordAfterIdResponse")
public class GetIORecordAfterIdResponse {

    @XmlElement(name = "GetIORecordAfterIdResult")
    protected ArrayOfIoRecordDataModel getIORecordAfterIdResult;

    /**
     * Gets the value of the getIORecordAfterIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIoRecordDataModel }
     *     
     */
    public ArrayOfIoRecordDataModel getGetIORecordAfterIdResult() {
        return getIORecordAfterIdResult;
    }

    /**
     * Sets the value of the getIORecordAfterIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIoRecordDataModel }
     *     
     */
    public void setGetIORecordAfterIdResult(ArrayOfIoRecordDataModel value) {
        this.getIORecordAfterIdResult = value;
    }

}
