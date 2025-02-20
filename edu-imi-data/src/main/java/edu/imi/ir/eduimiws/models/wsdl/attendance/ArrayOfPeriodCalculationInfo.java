
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPeriodCalculationInfo complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfPeriodCalculationInfo">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="PeriodCalculationInfo" type="{http://tempuri.org/}PeriodCalculationInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPeriodCalculationInfo", propOrder = {
    "periodCalculationInfo"
})
public class ArrayOfPeriodCalculationInfo {

    @XmlElement(name = "PeriodCalculationInfo", nillable = true)
    protected List<PeriodCalculationInfo> periodCalculationInfo;

    /**
     * Gets the value of the periodCalculationInfo property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the periodCalculationInfo property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getPeriodCalculationInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodCalculationInfo }
     * </p>
     * 
     * 
     * @return
     *     The value of the periodCalculationInfo property.
     */
    public List<PeriodCalculationInfo> getPeriodCalculationInfo() {
        if (periodCalculationInfo == null) {
            periodCalculationInfo = new ArrayList<>();
        }
        return this.periodCalculationInfo;
    }

}
