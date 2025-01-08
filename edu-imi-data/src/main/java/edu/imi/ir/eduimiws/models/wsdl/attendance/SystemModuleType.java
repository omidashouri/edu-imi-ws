
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SystemModuleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SystemModuleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TimeAttendanceSystem"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SystemModuleType")
@XmlEnum
public enum SystemModuleType {

    @XmlEnumValue("TimeAttendanceSystem")
    TIME_ATTENDANCE_SYSTEM("TimeAttendanceSystem");
    private final String value;

    SystemModuleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemModuleType fromValue(String v) {
        for (SystemModuleType c: SystemModuleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
