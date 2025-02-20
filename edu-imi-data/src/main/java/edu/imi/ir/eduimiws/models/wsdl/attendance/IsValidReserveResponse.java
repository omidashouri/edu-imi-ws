
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
 *         <element name="IsValidReserveResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isValidReserveResult"
})
@XmlRootElement(name = "IsValidReserveResponse")
public class IsValidReserveResponse {

    @XmlElement(name = "IsValidReserveResult")
    protected boolean isValidReserveResult;

    /**
     * Gets the value of the isValidReserveResult property.
     * 
     */
    public boolean isIsValidReserveResult() {
        return isValidReserveResult;
    }

    /**
     * Sets the value of the isValidReserveResult property.
     * 
     */
    public void setIsValidReserveResult(boolean value) {
        this.isValidReserveResult = value;
    }

}
