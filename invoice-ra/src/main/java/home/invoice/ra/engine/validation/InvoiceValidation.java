package home.invoice.ra.engine.validation;

import java.util.Set;

/**
 * Validation action to be performed on invoice data
 *
 * @author patm11
 * Created on 4/13/20
 */
public interface InvoiceValidation {

    /**
     * Validates the invoice input
     *
     * @return the violations
     */
    Set<InvoiceViolation> validate();
}
