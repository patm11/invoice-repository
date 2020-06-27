package home.invoice.ra.repository.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOME_SEQ")
    @Column(name = "INVOICE_ID", nullable = false)
    private Long id;

    @Column(name = "AMOUNT", nullable = false)
    private Float amount;

    @Column(name= "ISSUED_DATE")
    private Date issued;

    @Column(name = "DUE_DATE")
    private Date due;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ClientEntity client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
