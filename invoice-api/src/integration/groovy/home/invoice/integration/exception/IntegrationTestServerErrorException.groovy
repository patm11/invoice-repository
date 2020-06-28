package home.invoice.integration.exception


/**
 * @author patm11
 * Created on 6/28/20
 */
class IntegrationTestServerErrorException extends RuntimeException {

    IntegrationTestServerErrorException(String message) {
        super(message)
    }
}
