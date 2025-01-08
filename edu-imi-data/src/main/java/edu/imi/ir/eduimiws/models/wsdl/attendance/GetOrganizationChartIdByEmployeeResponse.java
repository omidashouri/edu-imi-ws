
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
 *         &lt;element name="GetOrganizationChartIdByEmployeeResult" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "getOrganizationChartIdByEmployeeResult"
})
@XmlRootElement(name = "GetOrganizationChartIdByEmployeeResponse")
public class GetOrganizationChartIdByEmployeeResponse {

    @XmlElement(name = "GetOrganizationChartIdByEmployeeResult")
    protected long getOrganizationChartIdByEmployeeResult;

    /**
     * Gets the value of the getOrganizationChartIdByEmployeeResult property.
     * 
     */
    public long getGetOrganizationChartIdByEmployeeResult() {
        return getOrganizationChartIdByEmployeeResult;
    }

    /**
     * Sets the value of the getOrganizationChartIdByEmployeeResult property.
     * 
     */
    public void setGetOrganizationChartIdByEmployeeResult(long value) {
        this.getOrganizationChartIdByEmployeeResult = value;
    }

}
