
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
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
 *         <element name="keyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="gregorianDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="shamsiDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="systemType" type="{http://tempuri.org/}SystemModuleType"/>
 *         <element name="deviceModuleType" type="{http://tempuri.org/}UiDeviceModuleType"/>
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
    "keyNumber",
    "gregorianDate",
    "shamsiDate",
    "systemType",
    "deviceModuleType"
})
@XmlRootElement(name = "GetEmployeeCodeByKeyNumber")
public class GetEmployeeCodeByKeyNumber {

    protected String keyNumber;
    protected String gregorianDate;
    protected String shamsiDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SystemModuleType systemType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected UiDeviceModuleType deviceModuleType;

    /**
     * Gets the value of the keyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyNumber() {
        return keyNumber;
    }

    /**
     * Sets the value of the keyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyNumber(String value) {
        this.keyNumber = value;
    }

    /**
     * Gets the value of the gregorianDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGregorianDate() {
        return gregorianDate;
    }

    /**
     * Sets the value of the gregorianDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGregorianDate(String value) {
        this.gregorianDate = value;
    }

    /**
     * Gets the value of the shamsiDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShamsiDate() {
        return shamsiDate;
    }

    /**
     * Sets the value of the shamsiDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShamsiDate(String value) {
        this.shamsiDate = value;
    }

    /**
     * Gets the value of the systemType property.
     * 
     * @return
     *     possible object is
     *     {@link SystemModuleType }
     *     
     */
    public SystemModuleType getSystemType() {
        return systemType;
    }

    /**
     * Sets the value of the systemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemModuleType }
     *     
     */
    public void setSystemType(SystemModuleType value) {
        this.systemType = value;
    }

    /**
     * Gets the value of the deviceModuleType property.
     * 
     * @return
     *     possible object is
     *     {@link UiDeviceModuleType }
     *     
     */
    public UiDeviceModuleType getDeviceModuleType() {
        return deviceModuleType;
    }

    /**
     * Sets the value of the deviceModuleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UiDeviceModuleType }
     *     
     */
    public void setDeviceModuleType(UiDeviceModuleType value) {
        this.deviceModuleType = value;
    }

}
