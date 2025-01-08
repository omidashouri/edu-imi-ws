
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
 *         &lt;element name="employeeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="periodId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="requestReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="specialExtraWorkId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="organizationChartId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "employeeCode",
    "value",
    "periodId",
    "requestReason",
    "description",
    "specialExtraWorkId",
    "organizationChartId"
})
@XmlRootElement(name = "AddSpecialExtraWorkPermission")
public class AddSpecialExtraWorkPermission {

    protected String employeeCode;
    protected int value;
    protected long periodId;
    protected String requestReason;
    protected String description;
    protected long specialExtraWorkId;
    protected long organizationChartId;

    /**
     * Gets the value of the employeeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * Sets the value of the employeeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeCode(String value) {
        this.employeeCode = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the periodId property.
     * 
     */
    public long getPeriodId() {
        return periodId;
    }

    /**
     * Sets the value of the periodId property.
     * 
     */
    public void setPeriodId(long value) {
        this.periodId = value;
    }

    /**
     * Gets the value of the requestReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestReason() {
        return requestReason;
    }

    /**
     * Sets the value of the requestReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestReason(String value) {
        this.requestReason = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the specialExtraWorkId property.
     * 
     */
    public long getSpecialExtraWorkId() {
        return specialExtraWorkId;
    }

    /**
     * Sets the value of the specialExtraWorkId property.
     * 
     */
    public void setSpecialExtraWorkId(long value) {
        this.specialExtraWorkId = value;
    }

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

}
