package home.invoice.ra.manager.impl

import home.invoice.model.Invoice
import home.invoice.ra.engine.MappingEngine
import home.invoice.ra.engine.ValidationEngine
import home.invoice.ra.engine.validation.InvoiceViolation
import home.invoice.ra.manager.InvoiceQueryManager
import home.invoice.ra.repository.InvoiceRepository
import home.invoice.ra.repository.model.ClientEntity
import home.invoice.ra.repository.model.InvoiceEntity
import spock.lang.Specification


/**
 * Spock unit test cases for {@link InvoiceQueryManagerImpl}
 *
 * @author patm11
 * Created on 6/27/20
 */
class InvoiceQueryManagerImplTest extends Specification {

    def validationEngine = Mock(ValidationEngine)
    def mappingEngine = Mock(MappingEngine)
    def repository = Mock(InvoiceRepository)

    InvoiceQueryManager manager

    def setup() {
        manager = new InvoiceQueryManagerImpl(validationEngine, mappingEngine, repository)
    }

    def "Can retrieve a valid and existing invoice successfully given the id"() {
        given:
            def id = "123"

            def entity = new InvoiceEntity(id: Long.parseLong(id), amount: 22.15, due: new Date(), issued: new Date(), client: new ClientEntity(name: "Bob"))
            def invoice = new Invoice(id: id, amount: 22.15, due: new Date(), issued: new Date(), client: "Bob")

        when:
            validationEngine.validateInvoiceId(id) >> new HashSet<InvoiceViolation>()
            repository.findById(Long.parseLong(id)) >> Optional.of(entity)
            mappingEngine.map(entity) >> invoice

            def result = manager.getInvoiceById(id)
        then:
            result == invoice
    }
}
