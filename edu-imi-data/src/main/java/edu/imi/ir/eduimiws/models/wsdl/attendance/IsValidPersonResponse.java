
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
 *         <element name="IsValidPersonResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isValidPersonResult"
})
@XmlRootElement(name = "IsValidPersonResponse")
public class IsValidPersonResponse {

    @XmlElement(name = "IsValidPersonResult")
    protected boolean isValidPersonResult;

    /**
     * Gets the value of the isValidPersonResult property.
     * 
     */
    public boolean isIsValidPersonResult() {
        return isValidPersonResult;
    }

    /**
     * Sets the value of the isValidPersonResult property.
     * 
     */
    public void setIsValidPersonResult(boolean value) {
        this.isValidPersonResult = value;
    }

}
