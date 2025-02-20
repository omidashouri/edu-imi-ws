
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
 *         <element name="GetOrganizationChartIdByEmployeeResult" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "getOrganizationChartIdByEmployeeResult"
})
@XmlRootElement(name = "GetOrganizationChartIdByEmployeeResponse")
public class GetOrganizationChartIdByEmployeeResponse {

    @XmlElement(name = "GetOrganizationChartIdByEmployeeResult")
    protected long getOrganizationChartIdByEmployeeResult;

    /**
     * Gets the value of the getOrganizationChartIdByEmployeeResult property.
     * 
     */
    public long getGetOrganizationChartIdByEmployeeResult() {
        return getOrganizationChartIdByEmployeeResult;
    }

    /**
     * Sets the value of the getOrganizationChartIdByEmployeeResult property.
     * 
     */
    public void setGetOrganizationChartIdByEmployeeResult(long value) {
        this.getOrganizationChartIdByEmployeeResult = value;
    }

}
