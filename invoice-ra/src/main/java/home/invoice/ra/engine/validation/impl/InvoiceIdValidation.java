package home.invoice.ra.engine.validation.impl;

import home.invoice.ra.engine.validation.InvoiceValidation;
import home.invoice.ra.engine.validation.InvoiceViolation;
import home.invoice.ra.utility.DataTypeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Validates the id for an invoice
 *
 * @author patm11
 * Created on 4/13/20
 */
public class InvoiceIdValidation implements InvoiceValidation {

    private final String id;

    /**
     * Constructs an instance given the string id
     *
     * @param id the id
     */
    public InvoiceIdValidation(String id) {
        this.id = id;
    }

    @Override
    public Set<InvoiceViolation> validate() {
        Set<InvoiceViolation> violations = new HashSet<>();

        if(!DataTypeUtils.isLong(id)) {
            violations.add(() -> "Invalid id");
        }

        return violations;
    }
}
