package home.invoice.client;

import home.invoice.model.Invoice;

/**
 * Defines methods the client can use on the invoice repository
 *
 * @author patm11
 * Created on 6/28/20
 */
public interface InvoiceRepositoryClient {

    /**
     * Gets an invoice from the repository given its id
     *
     * @param id the invoice id
     * @return the invoice
     */
    Invoice getInvoice(long id);
}
