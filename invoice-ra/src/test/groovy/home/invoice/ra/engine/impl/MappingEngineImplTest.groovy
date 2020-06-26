package home.invoice.ra.engine.impl

import home.invoice.model.Invoice
import home.invoice.ra.engine.MappingEngine
import home.invoice.ra.repository.InvoiceRepository
import home.invoice.ra.repository.model.ClientEntity
import home.invoice.ra.repository.model.InvoiceEntity
import spock.lang.Specification


/**
 * Spock unit test cases for {@link MappingEngineImpl}
 *
 * @author patm11
 * Created on 4/13/20
 */
class MappingEngineImplTest extends Specification {

    MappingEngine mappingEngine

    def invoiceRepository = Mock(InvoiceRepository)

    def setup() {
        mappingEngine = new MappingEngineImpl(invoiceRepository)
    }

    def "Can map an invoice entity into an invoice model"() {
        given:
            def id = 123L
            def clientName = "Bob"
            def client = new ClientEntity(name: clientName)
            def amount = 3.50D
            def due = new Date()
            def issued = new Date()
            def entity = new InvoiceEntity(id: id, client: client, amount: amount, due: due, issued: issued)

        when:
            def result = mappingEngine.map(entity)

        then:
            result.getId() == Long.toString(id)
            result.getClient() == clientName
            result.getAmount() == amount
            result.getIssued() == issued
            result.getDue() == due
    }

    def "Can map an invoice model into an invoice entity"() {
        given:
            def id = 1L
            def invoice = new Invoice(id: id.toString())

            def expected = new InvoiceEntity(id: id)

        when:
            invoiceRepository.findById(id) >> Optional.of(expected)

            def result = mappingEngine.map(invoice)

        then:
            result.getId() == expected.getId()
    }
}
