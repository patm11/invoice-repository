package home.invoice.integration

import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import home.invoice.client.InvoiceRepositoryClient
import home.invoice.client.feign.InvoiceRepositoryFeignClient
import home.invoice.client.impl.InvoiceRepositoryClientImpl
import home.invoice.integration.exception.IntegrationTestBadRequestException
import home.invoice.integration.exception.IntegrationTestNotFoundException
import home.invoice.integration.feign.IntegrationTestErrorDecoder
import spock.lang.Specification


/**
 * Integration tests for the get invoice by id endpoint
 *
 * @author patm11
 * Created on 6/28/20
 */
class GetInvoiceByIdTest extends Specification {

    private InvoiceRepositoryClient client
    private InvoiceRepositoryFeignClient feignClient

    def baseUrl = "http://localhost:8080"

    def setup() {
        if(!client) {
            client = new InvoiceRepositoryClientImpl(
                    baseUrl,
                    Feign.builder()
                            .encoder(new JacksonEncoder())
                            .decoder(new JacksonDecoder())
                            .errorDecoder(new IntegrationTestErrorDecoder())
            )
        }
        // need to build a feign client to be able to send bad input to the service
        if(!feignClient) {
            feignClient = InvoiceRepositoryFeignClient.buildClient(
                    baseUrl,
                    Feign.builder()
                            .encoder(new JacksonEncoder())
                            .decoder(new JacksonDecoder())
                            .errorDecoder(new IntegrationTestErrorDecoder())
            )
        }
    }

    def "Can get an invoice from the repository given its id"() {
        given:
            def id = 1

        when:
            def result = client.getInvoice(id)

        then:
            result
            result.getId() == Long.toString(id)
    }

    def "Receive a 404 response when requesting an id that does not exist"() {
        given:
            def id = 456

        when:
            client.getInvoice(id)

        then:
            thrown(IntegrationTestNotFoundException)
    }

    def "Receive a 400 response when requesting an id that does not conform to the id standard"() {
        given:
            def badId = "NotAnID"

        when:
            feignClient.getInvoice(badId)

        then:
            thrown(IntegrationTestBadRequestException)
    }
}
