package home.invoice.ra.exception;

/**
 * Exception to be thrown in the case of caught invalid input
 *
 * @author patm11
 * Created on 6/27/20
 */
public class InvoiceRepositoryBadRequestException extends RuntimeException {

    /**
     * Constructs an instance of the exception given the message
     *
     * @param message the exception message
     */
    public InvoiceRepositoryBadRequestException(String message) {
        super(message);
    }

    /**
     * Constructs an instance of the exception given the message and a cause
     *
     * @param message the message
     * @param cause the cause
     */
    public InvoiceRepositoryBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
