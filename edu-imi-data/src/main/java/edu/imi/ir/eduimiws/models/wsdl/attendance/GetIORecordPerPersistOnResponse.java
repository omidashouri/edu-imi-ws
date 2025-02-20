
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
 *         <element name="GetIORecordPerPersistOnResult" type="{http://tempuri.org/}ArrayOfIoRecordDataModel" minOccurs="0"/>
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
    "getIORecordPerPersistOnResult"
})
@XmlRootElement(name = "GetIORecordPerPersistOnResponse")
public class GetIORecordPerPersistOnResponse {

    @XmlElement(name = "GetIORecordPerPersistOnResult")
    protected ArrayOfIoRecordDataModel getIORecordPerPersistOnResult;

    /**
     * Gets the value of the getIORecordPerPersistOnResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIoRecordDataModel }
     *     
     */
    public ArrayOfIoRecordDataModel getGetIORecordPerPersistOnResult() {
        return getIORecordPerPersistOnResult;
    }

    /**
     * Sets the value of the getIORecordPerPersistOnResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIoRecordDataModel }
     *     
     */
    public void setGetIORecordPerPersistOnResult(ArrayOfIoRecordDataModel value) {
        this.getIORecordPerPersistOnResult = value;
    }

}
