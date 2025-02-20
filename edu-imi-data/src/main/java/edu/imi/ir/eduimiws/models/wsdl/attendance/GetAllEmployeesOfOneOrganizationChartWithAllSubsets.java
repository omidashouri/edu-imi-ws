
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
 *         <element name="currentOrganizationchartId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "currentOrganizationchartId"
})
@XmlRootElement(name = "GetAllEmployeesOfOneOrganizationChartWithAllSubsets")
public class GetAllEmployeesOfOneOrganizationChartWithAllSubsets {

    protected long currentOrganizationchartId;

    /**
     * Gets the value of the currentOrganizationchartId property.
     * 
     */
    public long getCurrentOrganizationchartId() {
        return currentOrganizationchartId;
    }

    /**
     * Sets the value of the currentOrganizationchartId property.
     * 
     */
    public void setCurrentOrganizationchartId(long value) {
        this.currentOrganizationchartId = value;
    }

}
