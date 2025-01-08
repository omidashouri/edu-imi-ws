
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
 *         &lt;element name="IsValidReserveResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
