package home.invoice.ra.engine.impl;

import home.invoice.ra.engine.ValidationEngine;
import home.invoice.ra.engine.validation.InvoiceViolation;
import home.invoice.ra.engine.validation.impl.InvoiceIdValidation;

import java.util.Set;

import static home.invoice.ra.engine.validation.ValidationUtility.runValidations;

/**
 * Validation engine implementation that validates inputs
 * in regards to the JPA entities
 *
 * @author patm11
 * Created on 4/13/20
 */
public class ValidationEngineImpl implements ValidationEngine {

    @Override
    public Set<InvoiceViolation> validateInvoiceId(String id) {
        return runValidations(new InvoiceIdValidation(id));
    }
}
