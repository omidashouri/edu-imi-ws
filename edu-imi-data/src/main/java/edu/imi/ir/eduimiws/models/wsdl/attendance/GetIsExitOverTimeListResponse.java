
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
 *         <element name="GetIsExitOverTimeListResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "getIsExitOverTimeListResult"
})
@XmlRootElement(name = "GetIsExitOverTimeListResponse")
public class GetIsExitOverTimeListResponse {

    @XmlElement(name = "GetIsExitOverTimeListResult")
    protected boolean getIsExitOverTimeListResult;

    /**
     * Gets the value of the getIsExitOverTimeListResult property.
     * 
     */
    public boolean isGetIsExitOverTimeListResult() {
        return getIsExitOverTimeListResult;
    }

    /**
     * Sets the value of the getIsExitOverTimeListResult property.
     * 
     */
    public void setGetIsExitOverTimeListResult(boolean value) {
        this.getIsExitOverTimeListResult = value;
    }

}
