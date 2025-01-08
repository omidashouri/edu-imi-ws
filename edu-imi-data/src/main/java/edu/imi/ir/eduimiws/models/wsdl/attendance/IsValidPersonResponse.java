
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
 *         &lt;element name="IsValidPersonResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
