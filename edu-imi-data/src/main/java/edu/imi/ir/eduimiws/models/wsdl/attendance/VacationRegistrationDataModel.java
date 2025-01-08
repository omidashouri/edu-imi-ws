
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VacationRegistrationDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VacationRegistrationDataModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="EmployeeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BusinessPartnerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DayOfWeekInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeginDateInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeginTimeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EndDateInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EndTimeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VacationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VacationTypeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AcceptanceStateInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "VacationRegistrationDataModel", propOrder = {
    "id",
    "employeeCode",
    "businessPartnerId",
    "fullName",
    "dayOfWeekInText",
    "beginDateInText",
    "beginTimeInText",
    "endDateInText",
    "endTimeInText",
    "vacationName",
    "vacationTypeInText",
    "acceptanceStateInText",
    "sourceTypeInText"
})
public class VacationRegistrationDataModel {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "EmployeeCode")
    protected String employeeCode;
    @XmlElement(name = "BusinessPartnerId", required = true, type = Long.class, nillable = true)
    protected Long businessPartnerId;
    @XmlElement(name = "FullName")
    protected String fullName;
    @XmlElement(name = "DayOfWeekInText")
    protected String dayOfWeekInText;
    @XmlElement(name = "BeginDateInText")
    protected String beginDateInText;
    @XmlElement(name = "BeginTimeInText")
    protected String beginTimeInText;
    @XmlElement(name = "EndDateInText")
    protected String endDateInText;
    @XmlElement(name = "EndTimeInText")
    protected String endTimeInText;
    @XmlElement(name = "VacationName")
    protected String vacationName;
    @XmlElement(name = "VacationTypeInText")
    protected String vacationTypeInText;
    @XmlElement(name = "AcceptanceStateInText")
    protected String acceptanceStateInText;
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
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessPartnerId() {
        return businessPartnerId;
    }

    /**
     * Sets the value of the businessPartnerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessPartnerId(Long value) {
        this.businessPartnerId = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the dayOfWeekInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayOfWeekInText() {
        return dayOfWeekInText;
    }

    /**
     * Sets the value of the dayOfWeekInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayOfWeekInText(String value) {
        this.dayOfWeekInText = value;
    }

    /**
     * Gets the value of the beginDateInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDateInText() {
        return beginDateInText;
    }

    /**
     * Sets the value of the beginDateInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDateInText(String value) {
        this.beginDateInText = value;
    }

    /**
     * Gets the value of the beginTimeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginTimeInText() {
        return beginTimeInText;
    }

    /**
     * Sets the value of the beginTimeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginTimeInText(String value) {
        this.beginTimeInText = value;
    }

    /**
     * Gets the value of the endDateInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateInText() {
        return endDateInText;
    }

    /**
     * Sets the value of the endDateInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateInText(String value) {
        this.endDateInText = value;
    }

    /**
     * Gets the value of the endTimeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTimeInText() {
        return endTimeInText;
    }

    /**
     * Sets the value of the endTimeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTimeInText(String value) {
        this.endTimeInText = value;
    }

    /**
     * Gets the value of the vacationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVacationName() {
        return vacationName;
    }

    /**
     * Sets the value of the vacationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVacationName(String value) {
        this.vacationName = value;
    }

    /**
     * Gets the value of the vacationTypeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVacationTypeInText() {
        return vacationTypeInText;
    }

    /**
     * Sets the value of the vacationTypeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVacationTypeInText(String value) {
        this.vacationTypeInText = value;
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
