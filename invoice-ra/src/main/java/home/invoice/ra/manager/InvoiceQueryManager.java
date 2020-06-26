package home.invoice.ra.manager;

import home.invoice.model.Invoice;

import java.util.List;
import java.util.Map;

/**
 * Query manager for invoice data
 *
 * @author patm11
 */
public interface InvoiceQueryManager {

    /**
     * Finds invoices with the given criteria
     *
     * @param criteria the criteria
     * @return the invoices matching the criteria
     */
    List<Invoice> findInvoicesByCriteria(Map<String, String> criteria);

    /**
     * Gets an invoice given its id
     *
     * @param id the id
     * @return the invoice
     */
    Invoice getInvoiceById(String id);
}
