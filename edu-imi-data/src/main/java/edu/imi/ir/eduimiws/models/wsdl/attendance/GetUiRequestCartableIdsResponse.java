
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
 *         <element name="GetUiRequestCartableIdsResult" type="{http://tempuri.org/}UiRequestCartableIds" minOccurs="0"/>
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
    "getUiRequestCartableIdsResult"
})
@XmlRootElement(name = "GetUiRequestCartableIdsResponse")
public class GetUiRequestCartableIdsResponse {

    @XmlElement(name = "GetUiRequestCartableIdsResult")
    protected UiRequestCartableIds getUiRequestCartableIdsResult;

    /**
     * Gets the value of the getUiRequestCartableIdsResult property.
     * 
     * @return
     *     possible object is
     *     {@link UiRequestCartableIds }
     *     
     */
    public UiRequestCartableIds getGetUiRequestCartableIdsResult() {
        return getUiRequestCartableIdsResult;
    }

    /**
     * Sets the value of the getUiRequestCartableIdsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UiRequestCartableIds }
     *     
     */
    public void setGetUiRequestCartableIdsResult(UiRequestCartableIds value) {
        this.getUiRequestCartableIdsResult = value;
    }

}
