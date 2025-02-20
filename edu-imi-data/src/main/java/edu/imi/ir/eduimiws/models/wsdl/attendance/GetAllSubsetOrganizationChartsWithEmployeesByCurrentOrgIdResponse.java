
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
 *         <element name="GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult" type="{http://tempuri.org/}ArrayOfOrganizationChartDataModel" minOccurs="0"/>
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
    "getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult"
})
@XmlRootElement(name = "GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResponse")
public class GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResponse {

    @XmlElement(name = "GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult")
    protected ArrayOfOrganizationChartDataModel getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult;

    /**
     * Gets the value of the getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOrganizationChartDataModel }
     *     
     */
    public ArrayOfOrganizationChartDataModel getGetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult() {
        return getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult;
    }

    /**
     * Sets the value of the getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOrganizationChartDataModel }
     *     
     */
    public void setGetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult(ArrayOfOrganizationChartDataModel value) {
        this.getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult = value;
    }

}
