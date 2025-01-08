
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodCalculationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodCalculationInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PCntDay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="FCntDay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdAmtAlwHurry" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdCntAlwHurry" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwhAmtNalwExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwhAmtAlwExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwAmtNormalNalwExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwAmtNormalAlwExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwSpecialExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwAmtExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdAmtAlwDelay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdCntAlwDelay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AccruedHolidayInDay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AccruedHolidayInMinutes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DeficitAccruedHolidayInDay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DeficitAccruedHolidayInMinutes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacAmtTotalPaidVacation" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MisAmtTotalMission" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationRemaining" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationQuota" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NwAmtTotalNightWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdAmtWorkDeficit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdAmtAbs" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdCntAbs" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdAmtHurry" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdCntHurry" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdAmtNalwExit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdAmtDelay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdCntDelay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdCntNalwExit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="WdSpecialWorkDeficit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PaidDaysCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PAmtInMission" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PAmtInVacation" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ServiceDelay" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="FFuncMin" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PresenceInWorkIntervals" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SpecialVacation" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SpecialDeficitVacation" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AssignedBoundWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwmhAmtAlwExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwmAmtExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwsAmtNalwExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EwsAmtAlwExtraWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MoreFunctionality" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="LessFunctionality" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails10Percent" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails15Percent" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails22Percent" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails35Percent" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails10PercentCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails15PercentCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails22PercentCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SequenceWorkingDetails35PercentCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationHourlyIsRight" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationDailyIsRight" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationDailyIsRightInDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationSickHourly" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationSickDaily" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationSickDailyInDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationNotPaidHourly" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationNotPaidDaily" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationNotPaidDailyInDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MissionDailyInDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VacationRemainingTransferedFromPreviousYear" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="FridayWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="HolidayWork" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CustomFunctionality" type="{http://tempuri.org/}ArrayOfDouble" minOccurs="0"/&gt;
 *         &lt;element name="PeriodId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="PeriodName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsDefaultYear" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodCalculationInfo", propOrder = {
    "pCntDay",
    "fCntDay",
    "wdAmtAlwHurry",
    "wdCntAlwHurry",
    "ewhAmtNalwExtraWork",
    "ewhAmtAlwExtraWork",
    "ewAmtNormalNalwExtraWork",
    "ewAmtNormalAlwExtraWork",
    "ewSpecialExtraWork",
    "ewAmtExtraWork",
    "wdAmtAlwDelay",
    "wdCntAlwDelay",
    "accruedHolidayInDay",
    "accruedHolidayInMinutes",
    "deficitAccruedHolidayInDay",
    "deficitAccruedHolidayInMinutes",
    "vacAmtTotalPaidVacation",
    "misAmtTotalMission",
    "vacationRemaining",
    "vacationQuota",
    "nwAmtTotalNightWork",
    "wdAmtWorkDeficit",
    "wdAmtAbs",
    "wdCntAbs",
    "wdAmtHurry",
    "wdCntHurry",
    "wdAmtNalwExit",
    "wdAmtDelay",
    "wdCntDelay",
    "wdCntNalwExit",
    "wdSpecialWorkDeficit",
    "paidDaysCount",
    "pAmtInMission",
    "pAmtInVacation",
    "serviceDelay",
    "fFuncMin",
    "presenceInWorkIntervals",
    "specialVacation",
    "specialDeficitVacation",
    "assignedBoundWork",
    "ewmhAmtAlwExtraWork",
    "ewmAmtExtraWork",
    "ewsAmtNalwExtraWork",
    "ewsAmtAlwExtraWork",
    "moreFunctionality",
    "lessFunctionality",
    "sequenceWorkingDetails10Percent",
    "sequenceWorkingDetails15Percent",
    "sequenceWorkingDetails22Percent",
    "sequenceWorkingDetails35Percent",
    "sequenceWorkingDetails10PercentCount",
    "sequenceWorkingDetails15PercentCount",
    "sequenceWorkingDetails22PercentCount",
    "sequenceWorkingDetails35PercentCount",
    "vacationHourlyIsRight",
    "vacationDailyIsRight",
    "vacationDailyIsRightInDays",
    "vacationSickHourly",
    "vacationSickDaily",
    "vacationSickDailyInDays",
    "vacationNotPaidHourly",
    "vacationNotPaidDaily",
    "vacationNotPaidDailyInDays",
    "missionDailyInDays",
    "vacationRemainingTransferedFromPreviousYear",
    "fridayWork",
    "holidayWork",
    "customFunctionality",
    "periodId",
    "periodName",
    "isDefaultYear"
})
public class PeriodCalculationInfo {

    @XmlElement(name = "PCntDay")
    protected int pCntDay;
    @XmlElement(name = "FCntDay")
    protected int fCntDay;
    @XmlElement(name = "WdAmtAlwHurry")
    protected int wdAmtAlwHurry;
    @XmlElement(name = "WdCntAlwHurry")
    protected int wdCntAlwHurry;
    @XmlElement(name = "EwhAmtNalwExtraWork")
    protected int ewhAmtNalwExtraWork;
    @XmlElement(name = "EwhAmtAlwExtraWork")
    protected int ewhAmtAlwExtraWork;
    @XmlElement(name = "EwAmtNormalNalwExtraWork")
    protected int ewAmtNormalNalwExtraWork;
    @XmlElement(name = "EwAmtNormalAlwExtraWork")
    protected int ewAmtNormalAlwExtraWork;
    @XmlElement(name = "EwSpecialExtraWork")
    protected int ewSpecialExtraWork;
    @XmlElement(name = "EwAmtExtraWork")
    protected int ewAmtExtraWork;
    @XmlElement(name = "WdAmtAlwDelay")
    protected int wdAmtAlwDelay;
    @XmlElement(name = "WdCntAlwDelay")
    protected int wdCntAlwDelay;
    @XmlElement(name = "AccruedHolidayInDay")
    protected int accruedHolidayInDay;
    @XmlElement(name = "AccruedHolidayInMinutes")
    protected int accruedHolidayInMinutes;
    @XmlElement(name = "DeficitAccruedHolidayInDay")
    protected int deficitAccruedHolidayInDay;
    @XmlElement(name = "DeficitAccruedHolidayInMinutes")
    protected int deficitAccruedHolidayInMinutes;
    @XmlElement(name = "VacAmtTotalPaidVacation")
    protected int vacAmtTotalPaidVacation;
    @XmlElement(name = "MisAmtTotalMission")
    protected int misAmtTotalMission;
    @XmlElement(name = "VacationRemaining")
    protected int vacationRemaining;
    @XmlElement(name = "VacationQuota")
    protected int vacationQuota;
    @XmlElement(name = "NwAmtTotalNightWork")
    protected int nwAmtTotalNightWork;
    @XmlElement(name = "WdAmtWorkDeficit")
    protected int wdAmtWorkDeficit;
    @XmlElement(name = "WdAmtAbs")
    protected int wdAmtAbs;
    @XmlElement(name = "WdCntAbs")
    protected int wdCntAbs;
    @XmlElement(name = "WdAmtHurry")
    protected int wdAmtHurry;
    @XmlElement(name = "WdCntHurry")
    protected int wdCntHurry;
    @XmlElement(name = "WdAmtNalwExit")
    protected int wdAmtNalwExit;
    @XmlElement(name = "WdAmtDelay")
    protected int wdAmtDelay;
    @XmlElement(name = "WdCntDelay")
    protected int wdCntDelay;
    @XmlElement(name = "WdCntNalwExit")
    protected int wdCntNalwExit;
    @XmlElement(name = "WdSpecialWorkDeficit")
    protected int wdSpecialWorkDeficit;
    @XmlElement(name = "PaidDaysCount")
    protected int paidDaysCount;
    @XmlElement(name = "PAmtInMission")
    protected int pAmtInMission;
    @XmlElement(name = "PAmtInVacation")
    protected int pAmtInVacation;
    @XmlElement(name = "ServiceDelay")
    protected int serviceDelay;
    @XmlElement(name = "FFuncMin")
    protected int fFuncMin;
    @XmlElement(name = "PresenceInWorkIntervals")
    protected int presenceInWorkIntervals;
    @XmlElement(name = "SpecialVacation")
    protected int specialVacation;
    @XmlElement(name = "SpecialDeficitVacation")
    protected int specialDeficitVacation;
    @XmlElement(name = "AssignedBoundWork")
    protected int assignedBoundWork;
    @XmlElement(name = "EwmhAmtAlwExtraWork")
    protected int ewmhAmtAlwExtraWork;
    @XmlElement(name = "EwmAmtExtraWork")
    protected int ewmAmtExtraWork;
    @XmlElement(name = "EwsAmtNalwExtraWork")
    protected int ewsAmtNalwExtraWork;
    @XmlElement(name = "EwsAmtAlwExtraWork")
    protected int ewsAmtAlwExtraWork;
    @XmlElement(name = "MoreFunctionality")
    protected int moreFunctionality;
    @XmlElement(name = "LessFunctionality")
    protected int lessFunctionality;
    @XmlElement(name = "SequenceWorkingDetails10Percent")
    protected int sequenceWorkingDetails10Percent;
    @XmlElement(name = "SequenceWorkingDetails15Percent")
    protected int sequenceWorkingDetails15Percent;
    @XmlElement(name = "SequenceWorkingDetails22Percent")
    protected int sequenceWorkingDetails22Percent;
    @XmlElement(name = "SequenceWorkingDetails35Percent")
    protected int sequenceWorkingDetails35Percent;
    @XmlElement(name = "SequenceWorkingDetails10PercentCount")
    protected int sequenceWorkingDetails10PercentCount;
    @XmlElement(name = "SequenceWorkingDetails15PercentCount")
    protected int sequenceWorkingDetails15PercentCount;
    @XmlElement(name = "SequenceWorkingDetails22PercentCount")
    protected int sequenceWorkingDetails22PercentCount;
    @XmlElement(name = "SequenceWorkingDetails35PercentCount")
    protected int sequenceWorkingDetails35PercentCount;
    @XmlElement(name = "VacationHourlyIsRight")
    protected int vacationHourlyIsRight;
    @XmlElement(name = "VacationDailyIsRight")
    protected int vacationDailyIsRight;
    @XmlElement(name = "VacationDailyIsRightInDays")
    protected int vacationDailyIsRightInDays;
    @XmlElement(name = "VacationSickHourly")
    protected int vacationSickHourly;
    @XmlElement(name = "VacationSickDaily")
    protected int vacationSickDaily;
    @XmlElement(name = "VacationSickDailyInDays")
    protected int vacationSickDailyInDays;
    @XmlElement(name = "VacationNotPaidHourly")
    protected int vacationNotPaidHourly;
    @XmlElement(name = "VacationNotPaidDaily")
    protected int vacationNotPaidDaily;
    @XmlElement(name = "VacationNotPaidDailyInDays")
    protected int vacationNotPaidDailyInDays;
    @XmlElement(name = "MissionDailyInDays")
    protected int missionDailyInDays;
    @XmlElement(name = "VacationRemainingTransferedFromPreviousYear")
    protected int vacationRemainingTransferedFromPreviousYear;
    @XmlElement(name = "FridayWork")
    protected int fridayWork;
    @XmlElement(name = "HolidayWork")
    protected int holidayWork;
    @XmlElement(name = "CustomFunctionality")
    protected ArrayOfDouble customFunctionality;
    @XmlElement(name = "PeriodId")
    protected long periodId;
    @XmlElement(name = "PeriodName")
    protected String periodName;
    @XmlElement(name = "IsDefaultYear")
    protected boolean isDefaultYear;

    /**
     * Gets the value of the pCntDay property.
     * 
     */
    public int getPCntDay() {
        return pCntDay;
    }

    /**
     * Sets the value of the pCntDay property.
     * 
     */
    public void setPCntDay(int value) {
        this.pCntDay = value;
    }

    /**
     * Gets the value of the fCntDay property.
     * 
     */
    public int getFCntDay() {
        return fCntDay;
    }

    /**
     * Sets the value of the fCntDay property.
     * 
     */
    public void setFCntDay(int value) {
        this.fCntDay = value;
    }

    /**
     * Gets the value of the wdAmtAlwHurry property.
     * 
     */
    public int getWdAmtAlwHurry() {
        return wdAmtAlwHurry;
    }

    /**
     * Sets the value of the wdAmtAlwHurry property.
     * 
     */
    public void setWdAmtAlwHurry(int value) {
        this.wdAmtAlwHurry = value;
    }

    /**
     * Gets the value of the wdCntAlwHurry property.
     * 
     */
    public int getWdCntAlwHurry() {
        return wdCntAlwHurry;
    }

    /**
     * Sets the value of the wdCntAlwHurry property.
     * 
     */
    public void setWdCntAlwHurry(int value) {
        this.wdCntAlwHurry = value;
    }

    /**
     * Gets the value of the ewhAmtNalwExtraWork property.
     * 
     */
    public int getEwhAmtNalwExtraWork() {
        return ewhAmtNalwExtraWork;
    }

    /**
     * Sets the value of the ewhAmtNalwExtraWork property.
     * 
     */
    public void setEwhAmtNalwExtraWork(int value) {
        this.ewhAmtNalwExtraWork = value;
    }

    /**
     * Gets the value of the ewhAmtAlwExtraWork property.
     * 
     */
    public int getEwhAmtAlwExtraWork() {
        return ewhAmtAlwExtraWork;
    }

    /**
     * Sets the value of the ewhAmtAlwExtraWork property.
     * 
     */
    public void setEwhAmtAlwExtraWork(int value) {
        this.ewhAmtAlwExtraWork = value;
    }

    /**
     * Gets the value of the ewAmtNormalNalwExtraWork property.
     * 
     */
    public int getEwAmtNormalNalwExtraWork() {
        return ewAmtNormalNalwExtraWork;
    }

    /**
     * Sets the value of the ewAmtNormalNalwExtraWork property.
     * 
     */
    public void setEwAmtNormalNalwExtraWork(int value) {
        this.ewAmtNormalNalwExtraWork = value;
    }

    /**
     * Gets the value of the ewAmtNormalAlwExtraWork property.
     * 
     */
    public int getEwAmtNormalAlwExtraWork() {
        return ewAmtNormalAlwExtraWork;
    }

    /**
     * Sets the value of the ewAmtNormalAlwExtraWork property.
     * 
     */
    public void setEwAmtNormalAlwExtraWork(int value) {
        this.ewAmtNormalAlwExtraWork = value;
    }

    /**
     * Gets the value of the ewSpecialExtraWork property.
     * 
     */
    public int getEwSpecialExtraWork() {
        return ewSpecialExtraWork;
    }

    /**
     * Sets the value of the ewSpecialExtraWork property.
     * 
     */
    public void setEwSpecialExtraWork(int value) {
        this.ewSpecialExtraWork = value;
    }

    /**
     * Gets the value of the ewAmtExtraWork property.
     * 
     */
    public int getEwAmtExtraWork() {
        return ewAmtExtraWork;
    }

    /**
     * Sets the value of the ewAmtExtraWork property.
     * 
     */
    public void setEwAmtExtraWork(int value) {
        this.ewAmtExtraWork = value;
    }

    /**
     * Gets the value of the wdAmtAlwDelay property.
     * 
     */
    public int getWdAmtAlwDelay() {
        return wdAmtAlwDelay;
    }

    /**
     * Sets the value of the wdAmtAlwDelay property.
     * 
     */
    public void setWdAmtAlwDelay(int value) {
        this.wdAmtAlwDelay = value;
    }

    /**
     * Gets the value of the wdCntAlwDelay property.
     * 
     */
    public int getWdCntAlwDelay() {
        return wdCntAlwDelay;
    }

    /**
     * Sets the value of the wdCntAlwDelay property.
     * 
     */
    public void setWdCntAlwDelay(int value) {
        this.wdCntAlwDelay = value;
    }

    /**
     * Gets the value of the accruedHolidayInDay property.
     * 
     */
    public int getAccruedHolidayInDay() {
        return accruedHolidayInDay;
    }

    /**
     * Sets the value of the accruedHolidayInDay property.
     * 
     */
    public void setAccruedHolidayInDay(int value) {
        this.accruedHolidayInDay = value;
    }

    /**
     * Gets the value of the accruedHolidayInMinutes property.
     * 
     */
    public int getAccruedHolidayInMinutes() {
        return accruedHolidayInMinutes;
    }

    /**
     * Sets the value of the accruedHolidayInMinutes property.
     * 
     */
    public void setAccruedHolidayInMinutes(int value) {
        this.accruedHolidayInMinutes = value;
    }

    /**
     * Gets the value of the deficitAccruedHolidayInDay property.
     * 
     */
    public int getDeficitAccruedHolidayInDay() {
        return deficitAccruedHolidayInDay;
    }

    /**
     * Sets the value of the deficitAccruedHolidayInDay property.
     * 
     */
    public void setDeficitAccruedHolidayInDay(int value) {
        this.deficitAccruedHolidayInDay = value;
    }

    /**
     * Gets the value of the deficitAccruedHolidayInMinutes property.
     * 
     */
    public int getDeficitAccruedHolidayInMinutes() {
        return deficitAccruedHolidayInMinutes;
    }

    /**
     * Sets the value of the deficitAccruedHolidayInMinutes property.
     * 
     */
    public void setDeficitAccruedHolidayInMinutes(int value) {
        this.deficitAccruedHolidayInMinutes = value;
    }

    /**
     * Gets the value of the vacAmtTotalPaidVacation property.
     * 
     */
    public int getVacAmtTotalPaidVacation() {
        return vacAmtTotalPaidVacation;
    }

    /**
     * Sets the value of the vacAmtTotalPaidVacation property.
     * 
     */
    public void setVacAmtTotalPaidVacation(int value) {
        this.vacAmtTotalPaidVacation = value;
    }

    /**
     * Gets the value of the misAmtTotalMission property.
     * 
     */
    public int getMisAmtTotalMission() {
        return misAmtTotalMission;
    }

    /**
     * Sets the value of the misAmtTotalMission property.
     * 
     */
    public void setMisAmtTotalMission(int value) {
        this.misAmtTotalMission = value;
    }

    /**
     * Gets the value of the vacationRemaining property.
     * 
     */
    public int getVacationRemaining() {
        return vacationRemaining;
    }

    /**
     * Sets the value of the vacationRemaining property.
     * 
     */
    public void setVacationRemaining(int value) {
        this.vacationRemaining = value;
    }

    /**
     * Gets the value of the vacationQuota property.
     * 
     */
    public int getVacationQuota() {
        return vacationQuota;
    }

    /**
     * Sets the value of the vacationQuota property.
     * 
     */
    public void setVacationQuota(int value) {
        this.vacationQuota = value;
    }

    /**
     * Gets the value of the nwAmtTotalNightWork property.
     * 
     */
    public int getNwAmtTotalNightWork() {
        return nwAmtTotalNightWork;
    }

    /**
     * Sets the value of the nwAmtTotalNightWork property.
     * 
     */
    public void setNwAmtTotalNightWork(int value) {
        this.nwAmtTotalNightWork = value;
    }

    /**
     * Gets the value of the wdAmtWorkDeficit property.
     * 
     */
    public int getWdAmtWorkDeficit() {
        return wdAmtWorkDeficit;
    }

    /**
     * Sets the value of the wdAmtWorkDeficit property.
     * 
     */
    public void setWdAmtWorkDeficit(int value) {
        this.wdAmtWorkDeficit = value;
    }

    /**
     * Gets the value of the wdAmtAbs property.
     * 
     */
    public int getWdAmtAbs() {
        return wdAmtAbs;
    }

    /**
     * Sets the value of the wdAmtAbs property.
     * 
     */
    public void setWdAmtAbs(int value) {
        this.wdAmtAbs = value;
    }

    /**
     * Gets the value of the wdCntAbs property.
     * 
     */
    public int getWdCntAbs() {
        return wdCntAbs;
    }

    /**
     * Sets the value of the wdCntAbs property.
     * 
     */
    public void setWdCntAbs(int value) {
        this.wdCntAbs = value;
    }

    /**
     * Gets the value of the wdAmtHurry property.
     * 
     */
    public int getWdAmtHurry() {
        return wdAmtHurry;
    }

    /**
     * Sets the value of the wdAmtHurry property.
     * 
     */
    public void setWdAmtHurry(int value) {
        this.wdAmtHurry = value;
    }

    /**
     * Gets the value of the wdCntHurry property.
     * 
     */
    public int getWdCntHurry() {
        return wdCntHurry;
    }

    /**
     * Sets the value of the wdCntHurry property.
     * 
     */
    public void setWdCntHurry(int value) {
        this.wdCntHurry = value;
    }

    /**
     * Gets the value of the wdAmtNalwExit property.
     * 
     */
    public int getWdAmtNalwExit() {
        return wdAmtNalwExit;
    }

    /**
     * Sets the value of the wdAmtNalwExit property.
     * 
     */
    public void setWdAmtNalwExit(int value) {
        this.wdAmtNalwExit = value;
    }

    /**
     * Gets the value of the wdAmtDelay property.
     * 
     */
    public int getWdAmtDelay() {
        return wdAmtDelay;
    }

    /**
     * Sets the value of the wdAmtDelay property.
     * 
     */
    public void setWdAmtDelay(int value) {
        this.wdAmtDelay = value;
    }

    /**
     * Gets the value of the wdCntDelay property.
     * 
     */
    public int getWdCntDelay() {
        return wdCntDelay;
    }

    /**
     * Sets the value of the wdCntDelay property.
     * 
     */
    public void setWdCntDelay(int value) {
        this.wdCntDelay = value;
    }

    /**
     * Gets the value of the wdCntNalwExit property.
     * 
     */
    public int getWdCntNalwExit() {
        return wdCntNalwExit;
    }

    /**
     * Sets the value of the wdCntNalwExit property.
     * 
     */
    public void setWdCntNalwExit(int value) {
        this.wdCntNalwExit = value;
    }

    /**
     * Gets the value of the wdSpecialWorkDeficit property.
     * 
     */
    public int getWdSpecialWorkDeficit() {
        return wdSpecialWorkDeficit;
    }

    /**
     * Sets the value of the wdSpecialWorkDeficit property.
     * 
     */
    public void setWdSpecialWorkDeficit(int value) {
        this.wdSpecialWorkDeficit = value;
    }

    /**
     * Gets the value of the paidDaysCount property.
     * 
     */
    public int getPaidDaysCount() {
        return paidDaysCount;
    }

    /**
     * Sets the value of the paidDaysCount property.
     * 
     */
    public void setPaidDaysCount(int value) {
        this.paidDaysCount = value;
    }

    /**
     * Gets the value of the pAmtInMission property.
     * 
     */
    public int getPAmtInMission() {
        return pAmtInMission;
    }

    /**
     * Sets the value of the pAmtInMission property.
     * 
     */
    public void setPAmtInMission(int value) {
        this.pAmtInMission = value;
    }

    /**
     * Gets the value of the pAmtInVacation property.
     * 
     */
    public int getPAmtInVacation() {
        return pAmtInVacation;
    }

    /**
     * Sets the value of the pAmtInVacation property.
     * 
     */
    public void setPAmtInVacation(int value) {
        this.pAmtInVacation = value;
    }

    /**
     * Gets the value of the serviceDelay property.
     * 
     */
    public int getServiceDelay() {
        return serviceDelay;
    }

    /**
     * Sets the value of the serviceDelay property.
     * 
     */
    public void setServiceDelay(int value) {
        this.serviceDelay = value;
    }

    /**
     * Gets the value of the fFuncMin property.
     * 
     */
    public int getFFuncMin() {
        return fFuncMin;
    }

    /**
     * Sets the value of the fFuncMin property.
     * 
     */
    public void setFFuncMin(int value) {
        this.fFuncMin = value;
    }

    /**
     * Gets the value of the presenceInWorkIntervals property.
     * 
     */
    public int getPresenceInWorkIntervals() {
        return presenceInWorkIntervals;
    }

    /**
     * Sets the value of the presenceInWorkIntervals property.
     * 
     */
    public void setPresenceInWorkIntervals(int value) {
        this.presenceInWorkIntervals = value;
    }

    /**
     * Gets the value of the specialVacation property.
     * 
     */
    public int getSpecialVacation() {
        return specialVacation;
    }

    /**
     * Sets the value of the specialVacation property.
     * 
     */
    public void setSpecialVacation(int value) {
        this.specialVacation = value;
    }

    /**
     * Gets the value of the specialDeficitVacation property.
     * 
     */
    public int getSpecialDeficitVacation() {
        return specialDeficitVacation;
    }

    /**
     * Sets the value of the specialDeficitVacation property.
     * 
     */
    public void setSpecialDeficitVacation(int value) {
        this.specialDeficitVacation = value;
    }

    /**
     * Gets the value of the assignedBoundWork property.
     * 
     */
    public int getAssignedBoundWork() {
        return assignedBoundWork;
    }

    /**
     * Sets the value of the assignedBoundWork property.
     * 
     */
    public void setAssignedBoundWork(int value) {
        this.assignedBoundWork = value;
    }

    /**
     * Gets the value of the ewmhAmtAlwExtraWork property.
     * 
     */
    public int getEwmhAmtAlwExtraWork() {
        return ewmhAmtAlwExtraWork;
    }

    /**
     * Sets the value of the ewmhAmtAlwExtraWork property.
     * 
     */
    public void setEwmhAmtAlwExtraWork(int value) {
        this.ewmhAmtAlwExtraWork = value;
    }

    /**
     * Gets the value of the ewmAmtExtraWork property.
     * 
     */
    public int getEwmAmtExtraWork() {
        return ewmAmtExtraWork;
    }

    /**
     * Sets the value of the ewmAmtExtraWork property.
     * 
     */
    public void setEwmAmtExtraWork(int value) {
        this.ewmAmtExtraWork = value;
    }

    /**
     * Gets the value of the ewsAmtNalwExtraWork property.
     * 
     */
    public int getEwsAmtNalwExtraWork() {
        return ewsAmtNalwExtraWork;
    }

    /**
     * Sets the value of the ewsAmtNalwExtraWork property.
     * 
     */
    public void setEwsAmtNalwExtraWork(int value) {
        this.ewsAmtNalwExtraWork = value;
    }

    /**
     * Gets the value of the ewsAmtAlwExtraWork property.
     * 
     */
    public int getEwsAmtAlwExtraWork() {
        return ewsAmtAlwExtraWork;
    }

    /**
     * Sets the value of the ewsAmtAlwExtraWork property.
     * 
     */
    public void setEwsAmtAlwExtraWork(int value) {
        this.ewsAmtAlwExtraWork = value;
    }

    /**
     * Gets the value of the moreFunctionality property.
     * 
     */
    public int getMoreFunctionality() {
        return moreFunctionality;
    }

    /**
     * Sets the value of the moreFunctionality property.
     * 
     */
    public void setMoreFunctionality(int value) {
        this.moreFunctionality = value;
    }

    /**
     * Gets the value of the lessFunctionality property.
     * 
     */
    public int getLessFunctionality() {
        return lessFunctionality;
    }

    /**
     * Sets the value of the lessFunctionality property.
     * 
     */
    public void setLessFunctionality(int value) {
        this.lessFunctionality = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails10Percent property.
     * 
     */
    public int getSequenceWorkingDetails10Percent() {
        return sequenceWorkingDetails10Percent;
    }

    /**
     * Sets the value of the sequenceWorkingDetails10Percent property.
     * 
     */
    public void setSequenceWorkingDetails10Percent(int value) {
        this.sequenceWorkingDetails10Percent = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails15Percent property.
     * 
     */
    public int getSequenceWorkingDetails15Percent() {
        return sequenceWorkingDetails15Percent;
    }

    /**
     * Sets the value of the sequenceWorkingDetails15Percent property.
     * 
     */
    public void setSequenceWorkingDetails15Percent(int value) {
        this.sequenceWorkingDetails15Percent = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails22Percent property.
     * 
     */
    public int getSequenceWorkingDetails22Percent() {
        return sequenceWorkingDetails22Percent;
    }

    /**
     * Sets the value of the sequenceWorkingDetails22Percent property.
     * 
     */
    public void setSequenceWorkingDetails22Percent(int value) {
        this.sequenceWorkingDetails22Percent = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails35Percent property.
     * 
     */
    public int getSequenceWorkingDetails35Percent() {
        return sequenceWorkingDetails35Percent;
    }

    /**
     * Sets the value of the sequenceWorkingDetails35Percent property.
     * 
     */
    public void setSequenceWorkingDetails35Percent(int value) {
        this.sequenceWorkingDetails35Percent = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails10PercentCount property.
     * 
     */
    public int getSequenceWorkingDetails10PercentCount() {
        return sequenceWorkingDetails10PercentCount;
    }

    /**
     * Sets the value of the sequenceWorkingDetails10PercentCount property.
     * 
     */
    public void setSequenceWorkingDetails10PercentCount(int value) {
        this.sequenceWorkingDetails10PercentCount = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails15PercentCount property.
     * 
     */
    public int getSequenceWorkingDetails15PercentCount() {
        return sequenceWorkingDetails15PercentCount;
    }

    /**
     * Sets the value of the sequenceWorkingDetails15PercentCount property.
     * 
     */
    public void setSequenceWorkingDetails15PercentCount(int value) {
        this.sequenceWorkingDetails15PercentCount = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails22PercentCount property.
     * 
     */
    public int getSequenceWorkingDetails22PercentCount() {
        return sequenceWorkingDetails22PercentCount;
    }

    /**
     * Sets the value of the sequenceWorkingDetails22PercentCount property.
     * 
     */
    public void setSequenceWorkingDetails22PercentCount(int value) {
        this.sequenceWorkingDetails22PercentCount = value;
    }

    /**
     * Gets the value of the sequenceWorkingDetails35PercentCount property.
     * 
     */
    public int getSequenceWorkingDetails35PercentCount() {
        return sequenceWorkingDetails35PercentCount;
    }

    /**
     * Sets the value of the sequenceWorkingDetails35PercentCount property.
     * 
     */
    public void setSequenceWorkingDetails35PercentCount(int value) {
        this.sequenceWorkingDetails35PercentCount = value;
    }

    /**
     * Gets the value of the vacationHourlyIsRight property.
     * 
     */
    public int getVacationHourlyIsRight() {
        return vacationHourlyIsRight;
    }

    /**
     * Sets the value of the vacationHourlyIsRight property.
     * 
     */
    public void setVacationHourlyIsRight(int value) {
        this.vacationHourlyIsRight = value;
    }

    /**
     * Gets the value of the vacationDailyIsRight property.
     * 
     */
    public int getVacationDailyIsRight() {
        return vacationDailyIsRight;
    }

    /**
     * Sets the value of the vacationDailyIsRight property.
     * 
     */
    public void setVacationDailyIsRight(int value) {
        this.vacationDailyIsRight = value;
    }

    /**
     * Gets the value of the vacationDailyIsRightInDays property.
     * 
     */
    public int getVacationDailyIsRightInDays() {
        return vacationDailyIsRightInDays;
    }

    /**
     * Sets the value of the vacationDailyIsRightInDays property.
     * 
     */
    public void setVacationDailyIsRightInDays(int value) {
        this.vacationDailyIsRightInDays = value;
    }

    /**
     * Gets the value of the vacationSickHourly property.
     * 
     */
    public int getVacationSickHourly() {
        return vacationSickHourly;
    }

    /**
     * Sets the value of the vacationSickHourly property.
     * 
     */
    public void setVacationSickHourly(int value) {
        this.vacationSickHourly = value;
    }

    /**
     * Gets the value of the vacationSickDaily property.
     * 
     */
    public int getVacationSickDaily() {
        return vacationSickDaily;
    }

    /**
     * Sets the value of the vacationSickDaily property.
     * 
     */
    public void setVacationSickDaily(int value) {
        this.vacationSickDaily = value;
    }

    /**
     * Gets the value of the vacationSickDailyInDays property.
     * 
     */
    public int getVacationSickDailyInDays() {
        return vacationSickDailyInDays;
    }

    /**
     * Sets the value of the vacationSickDailyInDays property.
     * 
     */
    public void setVacationSickDailyInDays(int value) {
        this.vacationSickDailyInDays = value;
    }

    /**
     * Gets the value of the vacationNotPaidHourly property.
     * 
     */
    public int getVacationNotPaidHourly() {
        return vacationNotPaidHourly;
    }

    /**
     * Sets the value of the vacationNotPaidHourly property.
     * 
     */
    public void setVacationNotPaidHourly(int value) {
        this.vacationNotPaidHourly = value;
    }

    /**
     * Gets the value of the vacationNotPaidDaily property.
     * 
     */
    public int getVacationNotPaidDaily() {
        return vacationNotPaidDaily;
    }

    /**
     * Sets the value of the vacationNotPaidDaily property.
     * 
     */
    public void setVacationNotPaidDaily(int value) {
        this.vacationNotPaidDaily = value;
    }

    /**
     * Gets the value of the vacationNotPaidDailyInDays property.
     * 
     */
    public int getVacationNotPaidDailyInDays() {
        return vacationNotPaidDailyInDays;
    }

    /**
     * Sets the value of the vacationNotPaidDailyInDays property.
     * 
     */
    public void setVacationNotPaidDailyInDays(int value) {
        this.vacationNotPaidDailyInDays = value;
    }

    /**
     * Gets the value of the missionDailyInDays property.
     * 
     */
    public int getMissionDailyInDays() {
        return missionDailyInDays;
    }

    /**
     * Sets the value of the missionDailyInDays property.
     * 
     */
    public void setMissionDailyInDays(int value) {
        this.missionDailyInDays = value;
    }

    /**
     * Gets the value of the vacationRemainingTransferedFromPreviousYear property.
     * 
     */
    public int getVacationRemainingTransferedFromPreviousYear() {
        return vacationRemainingTransferedFromPreviousYear;
    }

    /**
     * Sets the value of the vacationRemainingTransferedFromPreviousYear property.
     * 
     */
    public void setVacationRemainingTransferedFromPreviousYear(int value) {
        this.vacationRemainingTransferedFromPreviousYear = value;
    }

    /**
     * Gets the value of the fridayWork property.
     * 
     */
    public int getFridayWork() {
        return fridayWork;
    }

    /**
     * Sets the value of the fridayWork property.
     * 
     */
    public void setFridayWork(int value) {
        this.fridayWork = value;
    }

    /**
     * Gets the value of the holidayWork property.
     * 
     */
    public int getHolidayWork() {
        return holidayWork;
    }

    /**
     * Sets the value of the holidayWork property.
     * 
     */
    public void setHolidayWork(int value) {
        this.holidayWork = value;
    }

    /**
     * Gets the value of the customFunctionality property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDouble }
     *     
     */
    public ArrayOfDouble getCustomFunctionality() {
        return customFunctionality;
    }

    /**
     * Sets the value of the customFunctionality property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDouble }
     *     
     */
    public void setCustomFunctionality(ArrayOfDouble value) {
        this.customFunctionality = value;
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
     * Gets the value of the periodName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodName() {
        return periodName;
    }

    /**
     * Sets the value of the periodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodName(String value) {
        this.periodName = value;
    }

    /**
     * Gets the value of the isDefaultYear property.
     * 
     */
    public boolean isIsDefaultYear() {
        return isDefaultYear;
    }

    /**
     * Sets the value of the isDefaultYear property.
     * 
     */
    public void setIsDefaultYear(boolean value) {
        this.isDefaultYear = value;
    }

}
