package home.invoice.integration.exception


/**
 * An exception to be thrown in the event of a not found response
 * received by the client. This should be asserted by an integration test.
 *
 * @author patm11
 * Created on 6/28/20
 */
class IntegrationTestNotFoundException extends RuntimeException {

    /**
     * Constructs an instance of this exception
     *
     * @param message the message
     */
    IntegrationTestNotFoundException(String message) {
        super(message)
    }
}
