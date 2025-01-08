
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
 *         &lt;element name="GetIORecordPerDateRangeResult" type="{http://tempuri.org/}ArrayOfIoRecordDataModel" minOccurs="0"/&gt;
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
    "getIORecordPerDateRangeResult"
})
@XmlRootElement(name = "GetIORecordPerDateRangeResponse")
public class GetIORecordPerDateRangeResponse {

    @XmlElement(name = "GetIORecordPerDateRangeResult")
    protected ArrayOfIoRecordDataModel getIORecordPerDateRangeResult;

    /**
     * Gets the value of the getIORecordPerDateRangeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIoRecordDataModel }
     *     
     */
    public ArrayOfIoRecordDataModel getGetIORecordPerDateRangeResult() {
        return getIORecordPerDateRangeResult;
    }

    /**
     * Sets the value of the getIORecordPerDateRangeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIoRecordDataModel }
     *     
     */
    public void setGetIORecordPerDateRangeResult(ArrayOfIoRecordDataModel value) {
        this.getIORecordPerDateRangeResult = value;
    }

}
