
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IoRecordDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IoRecordDataModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="EmployeeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BusinessPartnerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DayOfWeekInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FinalDateInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FinalTimeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FinalRecordIoTypeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AcceptanceStateInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IoSourceTypeInText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IoRecordDataModel", propOrder = {
    "id",
    "employeeCode",
    "businessPartnerId",
    "fullName",
    "dayOfWeekInText",
    "finalDateInText",
    "finalTimeInText",
    "finalRecordIoTypeInText",
    "acceptanceStateInText",
    "ioSourceTypeInText"
})
public class IoRecordDataModel {

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
    @XmlElement(name = "FinalDateInText")
    protected String finalDateInText;
    @XmlElement(name = "FinalTimeInText")
    protected String finalTimeInText;
    @XmlElement(name = "FinalRecordIoTypeInText")
    protected String finalRecordIoTypeInText;
    @XmlElement(name = "AcceptanceStateInText")
    protected String acceptanceStateInText;
    @XmlElement(name = "IoSourceTypeInText")
    protected String ioSourceTypeInText;

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
     * Gets the value of the finalDateInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalDateInText() {
        return finalDateInText;
    }

    /**
     * Sets the value of the finalDateInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalDateInText(String value) {
        this.finalDateInText = value;
    }

    /**
     * Gets the value of the finalTimeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalTimeInText() {
        return finalTimeInText;
    }

    /**
     * Sets the value of the finalTimeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalTimeInText(String value) {
        this.finalTimeInText = value;
    }

    /**
     * Gets the value of the finalRecordIoTypeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalRecordIoTypeInText() {
        return finalRecordIoTypeInText;
    }

    /**
     * Sets the value of the finalRecordIoTypeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalRecordIoTypeInText(String value) {
        this.finalRecordIoTypeInText = value;
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
     * Gets the value of the ioSourceTypeInText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIoSourceTypeInText() {
        return ioSourceTypeInText;
    }

    /**
     * Sets the value of the ioSourceTypeInText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIoSourceTypeInText(String value) {
        this.ioSourceTypeInText = value;
    }

}
