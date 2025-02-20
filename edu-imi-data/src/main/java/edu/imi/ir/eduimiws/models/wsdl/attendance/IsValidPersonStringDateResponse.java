
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
 *         <element name="IsValidPersonStringDateResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isValidPersonStringDateResult"
})
@XmlRootElement(name = "IsValidPersonStringDateResponse")
public class IsValidPersonStringDateResponse {

    @XmlElement(name = "IsValidPersonStringDateResult")
    protected boolean isValidPersonStringDateResult;

    /**
     * Gets the value of the isValidPersonStringDateResult property.
     * 
     */
    public boolean isIsValidPersonStringDateResult() {
        return isValidPersonStringDateResult;
    }

    /**
     * Sets the value of the isValidPersonStringDateResult property.
     * 
     */
    public void setIsValidPersonStringDateResult(boolean value) {
        this.isValidPersonStringDateResult = value;
    }

}
