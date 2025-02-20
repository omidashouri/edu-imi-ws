
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
 *         <element name="GetIORecordPerDateRangeResult" type="{http://tempuri.org/}ArrayOfIoRecordDataModel" minOccurs="0"/>
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
