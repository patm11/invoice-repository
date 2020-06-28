package home.invoice.client.impl

import home.invoice.client.InvoiceRepositoryClient
import home.invoice.client.feign.InvoiceRepositoryFeignClient
import home.invoice.model.Invoice
import spock.lang.Specification


/**
 * Spock unit test cases for {@link InvoiceRepositoryClientImpl}
 *
 * @author patm11
 * Created on 6/28/20
 */
class InvoiceRepositoryClientImplTest extends Specification {

    def feignClient = Mock(InvoiceRepositoryFeignClient)

    InvoiceRepositoryClient client

    def setup() {
        client = new InvoiceRepositoryClientImpl(feignClient)
    }

    def "Can call the expected method with the expected inputs when calling get invoice by id"() {
        given:
            def id = 123
            def expected = new Invoice(
                    id: Long.toString(id),
                    client: "Bob",
                    due: new Date(),
                    issued: new Date(),
                    amount: 5451.67)

        when:
            feignClient.getInvoice(Long.toString(id)) >> expected

            def result = client.getInvoice(id)

        then:
            result == expected
    }
}
