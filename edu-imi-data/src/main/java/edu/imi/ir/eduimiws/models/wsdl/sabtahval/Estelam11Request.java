//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.01.30 at 02:03:28 PM GMT+03:30 
//


package edu.imi.ir.eduimiws.models.wsdl.sabtahval;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for estelam11Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="estelam11Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nin" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estelam11Request", propOrder = {
    "birthDate",
    "nin"
})
@XmlRootElement(name = "estelam11Request")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
public class Estelam11Request
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    private final static long serialVersionUID = 1L;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected int birthDate;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected long nin;

    /**
     * Gets the value of the birthDate property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public int getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setBirthDate(int value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the nin property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public long getNin() {
        return nin;
    }

    /**
     * Sets the value of the nin property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setNin(long value) {
        this.nin = value;
    }

}
