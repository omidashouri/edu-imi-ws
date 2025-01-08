
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPeriodCalculationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPeriodCalculationInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PeriodCalculationInfo" type="{http://tempuri.org/}PeriodCalculationInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the periodCalculationInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriodCalculationInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodCalculationInfo }
     * 
     * 
     */
    public List<PeriodCalculationInfo> getPeriodCalculationInfo() {
        if (periodCalculationInfo == null) {
            periodCalculationInfo = new ArrayList<PeriodCalculationInfo>();
        }
        return this.periodCalculationInfo;
    }

}
