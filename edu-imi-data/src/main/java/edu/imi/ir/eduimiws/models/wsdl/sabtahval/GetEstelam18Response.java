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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEstelam18Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEstelam18Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://est}Estelam18Result" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEstelam18Response", propOrder = {
    "_return"
})
@XmlRootElement(name = "getEstelam18Response")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
public class GetEstelam18Response
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "return")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected Estelam18Result _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link Estelam18Result }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public Estelam18Result getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link Estelam18Result }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setReturn(Estelam18Result value) {
        this._return = value;
    }

}
