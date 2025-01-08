
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfIoRecordDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfIoRecordDataModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IoRecordDataModel" type="{http://tempuri.org/}IoRecordDataModel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIoRecordDataModel", propOrder = {
    "ioRecordDataModel"
})
public class ArrayOfIoRecordDataModel {

    @XmlElement(name = "IoRecordDataModel", nillable = true)
    protected List<IoRecordDataModel> ioRecordDataModel;

    /**
     * Gets the value of the ioRecordDataModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ioRecordDataModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIoRecordDataModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IoRecordDataModel }
     * 
     * 
     */
    public List<IoRecordDataModel> getIoRecordDataModel() {
        if (ioRecordDataModel == null) {
            ioRecordDataModel = new ArrayList<IoRecordDataModel>();
        }
        return this.ioRecordDataModel;
    }

}
