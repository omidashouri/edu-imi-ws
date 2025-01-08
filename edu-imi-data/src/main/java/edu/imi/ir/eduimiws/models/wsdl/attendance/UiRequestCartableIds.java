
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UiRequestCartableIds complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UiRequestCartableIds"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IORecordRequests" type="{http://tempuri.org/}ArrayOfLong" minOccurs="0"/&gt;
 *         &lt;element name="VacationRegistrationRequests" type="{http://tempuri.org/}ArrayOfLong" minOccurs="0"/&gt;
 *         &lt;element name="MissionRegistrationRequests" type="{http://tempuri.org/}ArrayOfLong" minOccurs="0"/&gt;
 *         &lt;element name="DailyExtraWorkPermissionRequests" type="{http://tempuri.org/}ArrayOfLong" minOccurs="0"/&gt;
 *         &lt;element name="StandbyPermissionRequests" type="{http://tempuri.org/}ArrayOfLong" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UiRequestCartableIds", propOrder = {
    "ioRecordRequests",
    "vacationRegistrationRequests",
    "missionRegistrationRequests",
    "dailyExtraWorkPermissionRequests",
    "standbyPermissionRequests"
})
public class UiRequestCartableIds {

    @XmlElement(name = "IORecordRequests")
    protected ArrayOfLong ioRecordRequests;
    @XmlElement(name = "VacationRegistrationRequests")
    protected ArrayOfLong vacationRegistrationRequests;
    @XmlElement(name = "MissionRegistrationRequests")
    protected ArrayOfLong missionRegistrationRequests;
    @XmlElement(name = "DailyExtraWorkPermissionRequests")
    protected ArrayOfLong dailyExtraWorkPermissionRequests;
    @XmlElement(name = "StandbyPermissionRequests")
    protected ArrayOfLong standbyPermissionRequests;

    /**
     * Gets the value of the ioRecordRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getIORecordRequests() {
        return ioRecordRequests;
    }

    /**
     * Sets the value of the ioRecordRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setIORecordRequests(ArrayOfLong value) {
        this.ioRecordRequests = value;
    }

    /**
     * Gets the value of the vacationRegistrationRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getVacationRegistrationRequests() {
        return vacationRegistrationRequests;
    }

    /**
     * Sets the value of the vacationRegistrationRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setVacationRegistrationRequests(ArrayOfLong value) {
        this.vacationRegistrationRequests = value;
    }

    /**
     * Gets the value of the missionRegistrationRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getMissionRegistrationRequests() {
        return missionRegistrationRequests;
    }

    /**
     * Sets the value of the missionRegistrationRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setMissionRegistrationRequests(ArrayOfLong value) {
        this.missionRegistrationRequests = value;
    }

    /**
     * Gets the value of the dailyExtraWorkPermissionRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getDailyExtraWorkPermissionRequests() {
        return dailyExtraWorkPermissionRequests;
    }

    /**
     * Sets the value of the dailyExtraWorkPermissionRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setDailyExtraWorkPermissionRequests(ArrayOfLong value) {
        this.dailyExtraWorkPermissionRequests = value;
    }

    /**
     * Gets the value of the standbyPermissionRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getStandbyPermissionRequests() {
        return standbyPermissionRequests;
    }

    /**
     * Sets the value of the standbyPermissionRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setStandbyPermissionRequests(ArrayOfLong value) {
        this.standbyPermissionRequests = value;
    }

}
