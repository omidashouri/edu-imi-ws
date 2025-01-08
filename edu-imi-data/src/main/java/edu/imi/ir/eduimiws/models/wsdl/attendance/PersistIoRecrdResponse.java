
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
 *         &lt;element name="PersistIoRecrdResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "persistIoRecrdResult"
})
@XmlRootElement(name = "PersistIoRecrdResponse")
public class PersistIoRecrdResponse {

    @XmlElement(name = "PersistIoRecrdResult")
    protected boolean persistIoRecrdResult;

    /**
     * Gets the value of the persistIoRecrdResult property.
     * 
     */
    public boolean isPersistIoRecrdResult() {
        return persistIoRecrdResult;
    }

    /**
     * Sets the value of the persistIoRecrdResult property.
     * 
     */
    public void setPersistIoRecrdResult(boolean value) {
        this.persistIoRecrdResult = value;
    }

}
