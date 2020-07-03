package home.invoice.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Request object to for a new invoice
 *
 * @author patm11
 * Created on 7/2/20
 */
public class NewInvoiceRequest implements Serializable {

    private String clientName;
    private String phoneNumber;
    private String amount;
    private String due;
    private String issued;

    /**
     * Gets the client name
     *
     * @return the client name
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets the client name
     *
     * @param clientName the client name
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Gets the phone number
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the amount
     *
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     *
     * @param amount the amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the due date
     *
     * @return the due date
     */
    public String getDue() {
        return due;
    }

    /**
     * Sets the due date
     *
     * @param due the due date
     */
    public void setDue(String due) {
        this.due = due;
    }

    /**
     * Gets the issued date
     *
     * @return the issued date
     */
    public String getIssued() {
        return issued;
    }

    /**
     * Sets the issued date
     *
     * @param issued the issued date
     */
    public void setIssued(String issued) {
        this.issued = issued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NewInvoiceRequest that = (NewInvoiceRequest) o;

        return new EqualsBuilder()
                .append(clientName, that.clientName)
                .append(phoneNumber, that.phoneNumber)
                .append(amount, that.amount)
                .append(due, that.due)
                .append(issued, that.issued)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(clientName)
                .append(phoneNumber)
                .append(amount)
                .append(due)
                .append(issued)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("clientName", clientName)
                .append("phoneNumber", phoneNumber)
                .append("amount", amount)
                .append("due", due)
                .append("issued", issued)
                .toString();
    }
}
