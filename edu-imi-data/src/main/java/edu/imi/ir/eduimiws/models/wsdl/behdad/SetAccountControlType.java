
package edu.imi.ir.eduimiws.models.wsdl.behdad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setAccountControlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setAccountControlType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="credential" type="{com.misc.bis.behdad.service}credential" minOccurs="0"/&gt;
 *         &lt;element name="createModel" type="{com.misc.bis.behdad.service}accountControlCreateModel" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setAccountControlType", propOrder = {
    "credential",
    "createModel"
})
public class SetAccountControlType {

    protected Credential credential;
    protected AccountControlCreateModel createModel;

    /**
     * Gets the value of the credential property.
     * 
     * @return
     *     possible object is
     *     {@link Credential }
     *     
     */
    public Credential getCredential() {
        return credential;
    }

    /**
     * Sets the value of the credential property.
     * 
     * @param value
     *     allowed object is
     *     {@link Credential }
     *     
     */
    public void setCredential(Credential value) {
        this.credential = value;
    }

    /**
     * Gets the value of the createModel property.
     * 
     * @return
     *     possible object is
     *     {@link AccountControlCreateModel }
     *     
     */
    public AccountControlCreateModel getCreateModel() {
        return createModel;
    }

    /**
     * Sets the value of the createModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountControlCreateModel }
     *     
     */
    public void setCreateModel(AccountControlCreateModel value) {
        this.createModel = value;
    }

}
