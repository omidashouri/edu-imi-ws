
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
 *         <element name="GetAllEmployeesOfOneOrganizationChartWithAllSubsetsResult" type="{http://tempuri.org/}ArrayOfEmployeeDataModel" minOccurs="0"/>
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
    "getAllEmployeesOfOneOrganizationChartWithAllSubsetsResult"
})
@XmlRootElement(name = "GetAllEmployeesOfOneOrganizationChartWithAllSubsetsResponse")
public class GetAllEmployeesOfOneOrganizationChartWithAllSubsetsResponse {

    @XmlElement(name = "GetAllEmployeesOfOneOrganizationChartWithAllSubsetsResult")
    protected ArrayOfEmployeeDataModel getAllEmployeesOfOneOrganizationChartWithAllSubsetsResult;

    /**
     * Gets the value of the getAllEmployeesOfOneOrganizationChartWithAllSubsetsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public ArrayOfEmployeeDataModel getGetAllEmployeesOfOneOrganizationChartWithAllSubsetsResult() {
        return getAllEmployeesOfOneOrganizationChartWithAllSubsetsResult;
    }

    /**
     * Sets the value of the getAllEmployeesOfOneOrganizationChartWithAllSubsetsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public void setGetAllEmployeesOfOneOrganizationChartWithAllSubsetsResult(ArrayOfEmployeeDataModel value) {
        this.getAllEmployeesOfOneOrganizationChartWithAllSubsetsResult = value;
    }

}
