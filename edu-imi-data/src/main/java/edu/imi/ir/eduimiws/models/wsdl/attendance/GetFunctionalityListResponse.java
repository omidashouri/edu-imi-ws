
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
 *         <element name="GetFunctionalityListResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
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
    "getFunctionalityListResult"
})
@XmlRootElement(name = "GetFunctionalityListResponse")
public class GetFunctionalityListResponse {

    @XmlElement(name = "GetFunctionalityListResult")
    protected ArrayOfString getFunctionalityListResult;

    /**
     * Gets the value of the getFunctionalityListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetFunctionalityListResult() {
        return getFunctionalityListResult;
    }

    /**
     * Sets the value of the getFunctionalityListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetFunctionalityListResult(ArrayOfString value) {
        this.getFunctionalityListResult = value;
    }

}
