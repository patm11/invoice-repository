package home.invoice.ra.engine.validation;

/**
 * Validation engine constraint violation
 *
 * @author patm11
 * Created on 4/13/20
 */
public interface InvoiceViolation {

    /**
     * Gets the violation message
     *
     * @return the message
     */
    String getMessage();
}
