
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetOrganizationChartIdByEmployeeByIdResult" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getOrganizationChartIdByEmployeeByIdResult"
})
@XmlRootElement(name = "GetOrganizationChartIdByEmployeeByIdResponse")
public class GetOrganizationChartIdByEmployeeByIdResponse {

    @XmlElement(name = "GetOrganizationChartIdByEmployeeByIdResult", required = true, type = Long.class, nillable = true)
    protected Long getOrganizationChartIdByEmployeeByIdResult;

    /**
     * Gets the value of the getOrganizationChartIdByEmployeeByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGetOrganizationChartIdByEmployeeByIdResult() {
        return getOrganizationChartIdByEmployeeByIdResult;
    }

    /**
     * Sets the value of the getOrganizationChartIdByEmployeeByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGetOrganizationChartIdByEmployeeByIdResult(Long value) {
        this.getOrganizationChartIdByEmployeeByIdResult = value;
    }

}
