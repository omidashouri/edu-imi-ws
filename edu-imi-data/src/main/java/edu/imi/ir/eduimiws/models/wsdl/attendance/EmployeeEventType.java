
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EmployeeEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="EmployeeEventType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Present"/&gt;
 *     &lt;enumeration value="Absent"/&gt;
 *     &lt;enumeration value="IncompleteIo"/&gt;
 *     &lt;enumeration value="InVacation"/&gt;
 *     &lt;enumeration value="InMission"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EmployeeEventType")
@XmlEnum
public enum EmployeeEventType {

    @XmlEnumValue("Present")
    PRESENT("Present"),
    @XmlEnumValue("Absent")
    ABSENT("Absent"),
    @XmlEnumValue("IncompleteIo")
    INCOMPLETE_IO("IncompleteIo"),
    @XmlEnumValue("InVacation")
    IN_VACATION("InVacation"),
    @XmlEnumValue("InMission")
    IN_MISSION("InMission");
    private final String value;

    EmployeeEventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EmployeeEventType fromValue(String v) {
        for (EmployeeEventType c: EmployeeEventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
