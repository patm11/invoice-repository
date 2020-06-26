package home.invoice.ra.engine.validation;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility to simplify running a collection of invoice validations
 * and getting the potential violations
 *
 * @author patm11
 * Created on 4/13/20
 */
public class ValidationUtility {

    private ValidationUtility() {}

    /**
     * Runs through the validations for a varying number of invoice validations
     * and returns all violations encountered
     *
     * @param validations the validations
     * @return the violations
     */
    public static Set<InvoiceViolation> runValidations(InvoiceValidation... validations) {
        Set<InvoiceViolation> rVal = new HashSet<>();

        for(InvoiceValidation validation : validations) {
            rVal.addAll(validation.validate());
        }

        return rVal;
    }
}
