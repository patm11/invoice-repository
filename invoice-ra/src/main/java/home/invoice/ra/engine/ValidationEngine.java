package home.invoice.ra.engine;

import home.invoice.ra.engine.validation.InvoiceViolation;

import java.util.Set;

/**
 * Validates inputs to the repository
 * Ensures queries are well-formed and that writes
 * are valid per constraints
 *
 * @author patm11
 * Created on 4/13/20
 */
public interface ValidationEngine {

    /**
     * Validates the given invoice id
     *
     * @param id the id
     * @return the violations
     */
    Set<InvoiceViolation> validateInvoiceId(String id);
}
