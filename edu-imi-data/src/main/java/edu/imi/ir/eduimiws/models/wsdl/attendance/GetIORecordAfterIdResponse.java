
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
 *         <element name="GetIORecordAfterIdResult" type="{http://tempuri.org/}ArrayOfIoRecordDataModel" minOccurs="0"/>
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
