
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="currentOrganizationchartId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "currentOrganizationchartId"
})
@XmlRootElement(name = "GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId")
public class GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId {

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
