
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
 *         &lt;element name="GetRemainUiEmployeeVacationTypeRepositoryListResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/&gt;
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
    "getRemainUiEmployeeVacationTypeRepositoryListResult"
})
@XmlRootElement(name = "GetRemainUiEmployeeVacationTypeRepositoryListResponse")
public class GetRemainUiEmployeeVacationTypeRepositoryListResponse {

    @XmlElement(name = "GetRemainUiEmployeeVacationTypeRepositoryListResult")
    protected ArrayOfString getRemainUiEmployeeVacationTypeRepositoryListResult;

    /**
     * Gets the value of the getRemainUiEmployeeVacationTypeRepositoryListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetRemainUiEmployeeVacationTypeRepositoryListResult() {
        return getRemainUiEmployeeVacationTypeRepositoryListResult;
    }

    /**
     * Sets the value of the getRemainUiEmployeeVacationTypeRepositoryListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetRemainUiEmployeeVacationTypeRepositoryListResult(ArrayOfString value) {
        this.getRemainUiEmployeeVacationTypeRepositoryListResult = value;
    }

}
