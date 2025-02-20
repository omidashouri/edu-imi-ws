
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="GetAllOrganizationChartListResult" type="{http://tempuri.org/}ArrayOfOrganizationChartDataModel" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
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
