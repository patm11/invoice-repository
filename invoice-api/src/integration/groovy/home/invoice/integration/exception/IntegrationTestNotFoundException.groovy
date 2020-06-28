package home.invoice.integration.exception


/**
 * @author patm11
 * Created on 6/28/20
 */
class IntegrationTestNotFoundException extends RuntimeException {

    IntegrationTestNotFoundException(String message) {
        super(message)
    }
}
