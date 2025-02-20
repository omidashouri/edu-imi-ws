
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationChartDataModel complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="OrganizationChartDataModel">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="OrganizationChartId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="OrganizationChartName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Employees" type="{http://tempuri.org/}ArrayOfEmployeeDataModel" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationChartDataModel", propOrder = {
    "organizationChartId",
    "organizationChartName",
    "employees"
})
public class OrganizationChartDataModel {

    @XmlElement(name = "OrganizationChartId")
    protected long organizationChartId;
    @XmlElement(name = "OrganizationChartName")
    protected String organizationChartName;
    @XmlElement(name = "Employees")
    protected ArrayOfEmployeeDataModel employees;

    /**
     * Gets the value of the organizationChartId property.
     * 
     */
    public long getOrganizationChartId() {
        return organizationChartId;
    }

    /**
     * Sets the value of the organizationChartId property.
     * 
     */
    public void setOrganizationChartId(long value) {
        this.organizationChartId = value;
    }

    /**
     * Gets the value of the organizationChartName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationChartName() {
        return organizationChartName;
    }

    /**
     * Sets the value of the organizationChartName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationChartName(String value) {
        this.organizationChartName = value;
    }

    /**
     * Gets the value of the employees property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public ArrayOfEmployeeDataModel getEmployees() {
        return employees;
    }

    /**
     * Sets the value of the employees property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public void setEmployees(ArrayOfEmployeeDataModel value) {
        this.employees = value;
    }

}
