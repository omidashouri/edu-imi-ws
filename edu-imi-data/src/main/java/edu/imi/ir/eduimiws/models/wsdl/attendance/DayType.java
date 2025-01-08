
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DayType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="DayType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="WorkDay"/&gt;
 *     &lt;enumeration value="PublicHoliday"/&gt;
 *     &lt;enumeration value="AgreedHoliday"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DayType")
@XmlEnum
public enum DayType {

    @XmlEnumValue("WorkDay")
    WORK_DAY("WorkDay"),
    @XmlEnumValue("PublicHoliday")
    PUBLIC_HOLIDAY("PublicHoliday"),
    @XmlEnumValue("AgreedHoliday")
    AGREED_HOLIDAY("AgreedHoliday");
    private final String value;

    DayType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DayType fromValue(String v) {
        for (DayType c: DayType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
