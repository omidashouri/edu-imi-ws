
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
 *         &lt;element name="IsPresentResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "isPresentResult"
})
@XmlRootElement(name = "IsPresentResponse")
public class IsPresentResponse {

    @XmlElement(name = "IsPresentResult")
    protected boolean isPresentResult;

    /**
     * Gets the value of the isPresentResult property.
     * 
     */
    public boolean isIsPresentResult() {
        return isPresentResult;
    }

    /**
     * Sets the value of the isPresentResult property.
     * 
     */
    public void setIsPresentResult(boolean value) {
        this.isPresentResult = value;
    }

}
