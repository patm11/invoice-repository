package home.invoice.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Common invoice object model
 *
 * @author patm11
 */
public class Invoice implements Serializable {

    private String id;
    private Double amount;
    private String client;
    private Date issued;
    private Date due;

    /**
     * Gets the id
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the amount due
     *
     * @return the amount due
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount due
     *
     * @param amount the amount due
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets the client name
     *
     * @return the client name
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the client name
     *
     * @param client the client name
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Gets the date issued
     *
     * @return the date issued
     */
    public Date getIssued() {
        return issued;
    }

    /**
     * Sets the date issued
     *
     * @param issued the date issued
     */
    public void setIssued(Date issued) {
        this.issued = issued;
    }

    /**
     * Gets the due date
     *
     * @return the due date
     */
    public Date getDue() {
        return due;
    }

    /**
     * Sets the due date
     *
     * @param due the due date
     */
    public void setDue(Date due) {
        this.due = due;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        return new EqualsBuilder()
                .append(id, invoice.id)
                .append(amount, invoice.amount)
                .append(client, invoice.client)
                .append(issued, invoice.issued)
                .append(due, invoice.due)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(amount)
                .append(client)
                .append(issued)
                .append(due)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("amount", amount)
                .append("client", client)
                .append("issued", issued)
                .append("due", due)
                .toString();
    }
}
