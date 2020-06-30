package home.invoice.integration.exception


/**
 * Exception that is thrown in the event of a bad request by
 * the client. This should be asserted in an integration test
 *
 * @author patm11
 * Created on 6/28/20
 */
class IntegrationTestBadRequestException extends RuntimeException {

    /**
     * Constructs an instance of this exception
     *
     * @param message the message
     */
    IntegrationTestBadRequestException(String message) {
        super(message)
    }
}
