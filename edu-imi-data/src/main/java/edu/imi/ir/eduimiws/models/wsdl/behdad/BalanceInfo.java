
package edu.imi.ir.eduimiws.models.wsdl.behdad;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for balanceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="balanceInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="credit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="creditLimit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="monetary" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="reportDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="systemBlock" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="userBlock" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "balanceInfo", propOrder = {
    "credit",
    "creditLimit",
    "monetary",
    "reportDate",
    "systemBlock",
    "userBlock"
})
public class BalanceInfo {

    protected BigDecimal credit;
    protected BigDecimal creditLimit;
    protected BigDecimal monetary;
    protected String reportDate;
    protected BigDecimal systemBlock;
    protected BigDecimal userBlock;

    /**
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCredit(BigDecimal value) {
        this.credit = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditLimit(BigDecimal value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the monetary property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonetary() {
        return monetary;
    }

    /**
     * Sets the value of the monetary property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonetary(BigDecimal value) {
        this.monetary = value;
    }

    /**
     * Gets the value of the reportDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDate() {
        return reportDate;
    }

    /**
     * Sets the value of the reportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDate(String value) {
        this.reportDate = value;
    }

    /**
     * Gets the value of the systemBlock property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSystemBlock() {
        return systemBlock;
    }

    /**
     * Sets the value of the systemBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSystemBlock(BigDecimal value) {
        this.systemBlock = value;
    }

    /**
     * Gets the value of the userBlock property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUserBlock() {
        return userBlock;
    }

    /**
     * Sets the value of the userBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUserBlock(BigDecimal value) {
        this.userBlock = value;
    }

}
