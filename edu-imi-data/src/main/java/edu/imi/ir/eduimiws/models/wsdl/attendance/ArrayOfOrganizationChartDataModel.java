
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOrganizationChartDataModel complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfOrganizationChartDataModel">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="OrganizationChartDataModel" type="{http://tempuri.org/}OrganizationChartDataModel" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOrganizationChartDataModel", propOrder = {
    "organizationChartDataModel"
})
public class ArrayOfOrganizationChartDataModel {

    @XmlElement(name = "OrganizationChartDataModel", nillable = true)
    protected List<OrganizationChartDataModel> organizationChartDataModel;

    /**
     * Gets the value of the organizationChartDataModel property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizationChartDataModel property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getOrganizationChartDataModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationChartDataModel }
     * </p>
     * 
     * 
     * @return
     *     The value of the organizationChartDataModel property.
     */
    public List<OrganizationChartDataModel> getOrganizationChartDataModel() {
        if (organizationChartDataModel == null) {
            organizationChartDataModel = new ArrayList<>();
        }
        return this.organizationChartDataModel;
    }

}
