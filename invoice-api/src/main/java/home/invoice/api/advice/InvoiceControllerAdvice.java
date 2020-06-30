package home.invoice.api.advice;

import home.invoice.ra.exception.InvoiceRepositoryBadRequestException;
import home.invoice.ra.exception.InvoiceRepositoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Directs the invoice controller on what HTTP codes to return upon
 * receiving given exceptions.
 *
 * All unlisted/uncaught exceptions will return a 500 HTTP response code
 *
 * @author patm11
 * Created on 6/27/20
 */
@ControllerAdvice
public class InvoiceControllerAdvice {

    /**
     * Returns a 404 HTTP response code if any exception classes
     * within the exception handler annotation are received
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ InvoiceRepositoryNotFoundException.class })
    public void handleNotFound() {
        // no further code needed
    }

    /**
     * Returns a 400 HTTP response code if any exception classes
     * within the exception handler annotation are received
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ InvoiceRepositoryBadRequestException.class })
    public void handleBadRequest() {
        // no further code needed
    }
}
