
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UiDeviceModuleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="UiDeviceModuleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Fing"/&gt;
 *     &lt;enumeration value="Face"/&gt;
 *     &lt;enumeration value="Card"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UiDeviceModuleType")
@XmlEnum
public enum UiDeviceModuleType {

    @XmlEnumValue("Fing")
    FING("Fing"),
    @XmlEnumValue("Face")
    FACE("Face"),
    @XmlEnumValue("Card")
    CARD("Card");
    private final String value;

    UiDeviceModuleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UiDeviceModuleType fromValue(String v) {
        for (UiDeviceModuleType c: UiDeviceModuleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
