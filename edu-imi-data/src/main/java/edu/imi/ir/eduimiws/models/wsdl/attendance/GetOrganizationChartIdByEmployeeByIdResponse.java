
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
 *         <element name="GetOrganizationChartIdByEmployeeByIdResult" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "getOrganizationChartIdByEmployeeByIdResult"
})
@XmlRootElement(name = "GetOrganizationChartIdByEmployeeByIdResponse")
public class GetOrganizationChartIdByEmployeeByIdResponse {

    @XmlElement(name = "GetOrganizationChartIdByEmployeeByIdResult", required = true, type = Long.class, nillable = true)
    protected Long getOrganizationChartIdByEmployeeByIdResult;

    /**
     * Gets the value of the getOrganizationChartIdByEmployeeByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGetOrganizationChartIdByEmployeeByIdResult() {
        return getOrganizationChartIdByEmployeeByIdResult;
    }

    /**
     * Sets the value of the getOrganizationChartIdByEmployeeByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGetOrganizationChartIdByEmployeeByIdResult(Long value) {
        this.getOrganizationChartIdByEmployeeByIdResult = value;
    }

}
