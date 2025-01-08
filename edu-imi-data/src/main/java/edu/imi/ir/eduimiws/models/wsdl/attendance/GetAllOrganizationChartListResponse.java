
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
 *         &lt;element name="GetAllOrganizationChartListResult" type="{http://tempuri.org/}ArrayOfOrganizationChartDataModel" minOccurs="0"/&gt;
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
    "getAllOrganizationChartListResult"
})
@XmlRootElement(name = "GetAllOrganizationChartListResponse")
public class GetAllOrganizationChartListResponse {

    @XmlElement(name = "GetAllOrganizationChartListResult")
    protected ArrayOfOrganizationChartDataModel getAllOrganizationChartListResult;

    /**
     * Gets the value of the getAllOrganizationChartListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOrganizationChartDataModel }
     *     
     */
    public ArrayOfOrganizationChartDataModel getGetAllOrganizationChartListResult() {
        return getAllOrganizationChartListResult;
    }

    /**
     * Sets the value of the getAllOrganizationChartListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOrganizationChartDataModel }
     *     
     */
    public void setGetAllOrganizationChartListResult(ArrayOfOrganizationChartDataModel value) {
        this.getAllOrganizationChartListResult = value;
    }

}
