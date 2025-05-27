
package edu.imi.ir.eduimiws.models.wsdl.behdad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPagedSourceSideTransactions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPagedSourceSideTransactions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="credential" type="{com.misc.bis.behdad.service}credential" minOccurs="0"/&gt;
 *         &lt;element name="sideTransactionsRequest" type="{com.misc.bis.behdad.service}sideTransactionsRequest" minOccurs="0"/&gt;
 *         &lt;element name="paging" type="{com.misc.bis.behdad.service}paging" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPagedSourceSideTransactions", propOrder = {
    "credential",
    "sideTransactionsRequest",
    "paging"
})
public class GetPagedSourceSideTransactions {

    protected Credential credential;
    protected SideTransactionsRequest sideTransactionsRequest;
    protected Paging paging;

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
     * Gets the value of the sideTransactionsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SideTransactionsRequest }
     *     
     */
    public SideTransactionsRequest getSideTransactionsRequest() {
        return sideTransactionsRequest;
    }

    /**
     * Sets the value of the sideTransactionsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SideTransactionsRequest }
     *     
     */
    public void setSideTransactionsRequest(SideTransactionsRequest value) {
        this.sideTransactionsRequest = value;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link Paging }
     *     
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paging }
     *     
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

}
