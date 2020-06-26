package home.invoice.api.controller

import home.invoice.model.Invoice
import home.invoice.ra.manager.InvoiceCommandManager
import home.invoice.ra.manager.InvoiceQueryManager
import spock.lang.Specification

class InvoiceControllerTest extends Specification {

    InvoiceController controller

    def queryManager = Mock(InvoiceQueryManager)
    def commandManager = Mock(InvoiceCommandManager)

    def setup() {
        controller = new InvoiceController(queryManager, commandManager)
    }

    def "Can call the expected resources with get invoice by id"() {
        given:
            def id = "1"
            def expected = new Invoice(client: "Bob",
                    id: "1",
                    amount: 1.50D,
                    due: new Date(),
                    issued: new Date())

        when:
            queryManager.getInvoiceById(id) >> expected

            def result = controller.getInvoiceById(id)

        then:
            expected == result
    }

    def "Can call the expected resources with expected arguments for find invoices"() {
        given:
            def criteria = ["dueDateGt": "12345", "dueDateLt": "56789"]
            def expected = [new Invoice(due: new Date(), id: "123")]

        when:
            queryManager.findInvoicesByCriteria(criteria) >> expected

            def result = controller.findInvoicesByCriteria(criteria)

        then:
            result == expected
    }
}
