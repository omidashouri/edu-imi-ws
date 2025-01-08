
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DailyExtraWorkPermissionDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DailyExtraWorkPermissionDataModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="EmployeeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BusinessPartnerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="EmployeeFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeginDateTimeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EndDateTimeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PermissionValue" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AcceptanceStateInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PermissionTypeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SourceTypeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DailyExtraWorkPermissionDataModel", propOrder = {
    "id",
    "employeeCode",
    "businessPartnerId",
    "employeeFullName",
    "beginDateTimeInText",
    "endDateTimeInText",
    "permissionValue",
    "acceptanceStateInText",
    "permissionTypeInText",
    "sourceTypeInText"
})
public class DailyExtraWorkPermissionDataModel {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "EmployeeCode")
    protected String employeeCode;
    @XmlElement(name = "BusinessPartnerId")
    protected long businessPartnerId;
    @XmlElement(name = "EmployeeFullName")
    protected String employeeFullName;
    @XmlElement(name = "BeginDateTimeInText")
    protected String beginDateTimeInText;
    @XmlElement(name = "EndDateTimeInText")
    protected String endDateTimeInText;
    @XmlElement(name = "PermissionValue")
    protected int permissionValue;
    @XmlElement(name = "AcceptanceStateInText")
    protected String acceptanceStateInText;
    @XmlElement(name = "PermissionTypeInText")
    protected String permissionTypeInText;
    @XmlElement(name = "SourceTypeInText")
    protected String sourceTypeInText;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

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
     * Gets the value of the businessPartnerId property.
     * 
     */
    public long getBusinessPartnerId() {
        return businessPartnerId;
    }

    /**
     * Sets the value of the businessPartnerId property.
     * 
     */
    public void setBusinessPartnerId(long value) {
        this.businessPartnerId = value;
    }

    /**
     * Gets the value of the employeeFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeFullName() {
        return employeeFullName;
    }

    /**
     * Sets the value of the employeeFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeFullName(String value) {
        this.employeeFullName = value;
    }

    /**
     * Gets the value of the beginDateTimeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDateTimeInText() {
        return beginDateTimeInText;
    }

    /**
     * Sets the value of the beginDateTimeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDateTimeInText(String value) {
        this.beginDateTimeInText = value;
    }

    /**
     * Gets the value of the endDateTimeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateTimeInText() {
        return endDateTimeInText;
    }

    /**
     * Sets the value of the endDateTimeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateTimeInText(String value) {
        this.endDateTimeInText = value;
    }

    /**
     * Gets the value of the permissionValue property.
     * 
     */
    public int getPermissionValue() {
        return permissionValue;
    }

    /**
     * Sets the value of the permissionValue property.
     * 
     */
    public void setPermissionValue(int value) {
        this.permissionValue = value;
    }

    /**
     * Gets the value of the acceptanceStateInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceptanceStateInText() {
        return acceptanceStateInText;
    }

    /**
     * Sets the value of the acceptanceStateInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceptanceStateInText(String value) {
        this.acceptanceStateInText = value;
    }

    /**
     * Gets the value of the permissionTypeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermissionTypeInText() {
        return permissionTypeInText;
    }

    /**
     * Sets the value of the permissionTypeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermissionTypeInText(String value) {
        this.permissionTypeInText = value;
    }

    /**
     * Gets the value of the sourceTypeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceTypeInText() {
        return sourceTypeInText;
    }

    /**
     * Sets the value of the sourceTypeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceTypeInText(String value) {
        this.sourceTypeInText = value;
    }

}
