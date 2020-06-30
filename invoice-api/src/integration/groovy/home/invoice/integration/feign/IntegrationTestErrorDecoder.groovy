package home.invoice.integration.feign

import feign.Response
import feign.codec.ErrorDecoder
import home.invoice.integration.exception.IntegrationTestBadRequestException
import home.invoice.integration.exception.IntegrationTestNotFoundException
import home.invoice.integration.exception.IntegrationTestServerErrorException


/**
 * Error decoder to be used in integration tests
 * Tests will catch the specific integration test exceptions thrown by the HTTP response code
 *
 * @author patm11
 * Created on 6/28/20
 */
class IntegrationTestErrorDecoder implements ErrorDecoder {

    @Override
    Exception decode(String methodKey, Response response) {
        Exception toThrow

        switch(response.status()) {
            case 400:
                toThrow = new IntegrationTestBadRequestException("Bad Request")
                break
            case 404:
                toThrow = new IntegrationTestNotFoundException("Not Found")
                break
            default:
                toThrow = new IntegrationTestServerErrorException("Server Error")
                break
        }

        return toThrow;
    }
}
