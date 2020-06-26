package home.invoice.ra.engine;

import home.invoice.model.Invoice;
import home.invoice.ra.repository.model.InvoiceEntity;

/**
 * The mapping engine that translates database models into
 * the models that are distributed by this application
 *
 * @author patm11
 * Created on 4/13/20
 */
public interface MappingEngine {

    /**
     * Maps an invoice entity into an invoice model
     *
     * @param entity the entity
     * @return the invoice model
     */
    Invoice map(InvoiceEntity entity);

    /**
     * Maps an invoice model into an invoice entity
     *
     * @param model the model
     * @return the invoice entity
     */
    InvoiceEntity map(Invoice model);
}
