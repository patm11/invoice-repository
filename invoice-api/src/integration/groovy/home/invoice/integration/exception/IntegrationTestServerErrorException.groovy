package home.invoice.integration.exception


/**
 * An exception to be thrown in the event of any unaccounted for error
 * received by the client. This should be assertied in a unit test
 *
 * @author patm11
 * Created on 6/28/20
 */
class IntegrationTestServerErrorException extends RuntimeException {

    /**
     * Constructs an instance of this exception
     *
     * @param message the message
     */
    IntegrationTestServerErrorException(String message) {
        super(message)
    }
}
