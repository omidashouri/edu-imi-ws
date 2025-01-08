
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
 *         &lt;element name="GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgIdResult" type="{http://tempuri.org/}ArrayOfOrganizationChartDataModel" minOccurs="0"/&gt;
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
