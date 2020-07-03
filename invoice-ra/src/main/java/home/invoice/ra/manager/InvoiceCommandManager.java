package home.invoice.ra.manager;

import java.util.Date;

/**
 * Command manager for invoice data
 *
 * @author patm11
 */
public interface InvoiceCommandManager {

    /**
     * Creates a new invoice
     * If the client does not exist, they will be added to the database
     *
     * @param client the client name
     * @param phoneNumber the phone number
     * @param issued the date issued
     * @param due the date due
     * @param amount the amount due
     */
    void createInvoice(String client, String phoneNumber, String issued, String due, String amount);

    /**
     * Saves updated data for an existing invoice
     *
     * @param id the id
     * @param due the date due
     * @param amount the amount due
     */
    void saveInvoice(String id, Date due, Double amount);

    /**
     * Deletes an invoice given the id
     *
     * @param id the id
     */
    void deleteInvoice(String id);
}
