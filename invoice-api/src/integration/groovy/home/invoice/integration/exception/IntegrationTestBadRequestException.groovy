package home.invoice.integration.exception


/**
 * @author patm11
 * Created on 6/28/20
 */
class IntegrationTestBadRequestException extends RuntimeException {

    IntegrationTestBadRequestException(String message) {
        super(message)
    }
}
