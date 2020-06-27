package home.invoice.ra.exception;

/**
 * Exception to be thrown in the event of an empty result set from a search
 *
 * @author patm11
 * Created on 6/27/20
 */
public class InvoiceRepositoryNotFoundException extends RuntimeException {

    /**
     * Constructs an instance of the exception given the message
     *
     * @param message the exception message
     */
    public InvoiceRepositoryNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs an instance of the exception given the message and a cause
     *
     * @param message the exception message
     * @param cause the cause
     */
    public InvoiceRepositoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
