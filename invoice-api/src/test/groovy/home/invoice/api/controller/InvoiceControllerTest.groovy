package home.invoice.api.controller

import home.invoice.model.Invoice
import home.invoice.model.NewInvoiceRequest
import home.invoice.ra.manager.InvoiceCommandManager
import home.invoice.ra.manager.InvoiceQueryManager
import spock.lang.Specification

/**
 * Spock unit tests for {@link InvoiceController}
 *
 * @author patm11
 */
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

    def "Can call the expected resources with expected arguments for create invoice"() {
        given:
            def client = "Bob"
            def phoneNumber = "(555) 867-5309"
            def issued = new Date()
            def dueDate = Calendar.getInstance()
            dueDate.add(Calendar.MONTH, 1)
            dueDate = dueDate.getTime()
            def amount = "2020.56"
            def request = new NewInvoiceRequest(
                    clientName: client,
                    phoneNumber: phoneNumber,
                    due: Long.toString(dueDate.getTime()),
                    issued: Long.toString(issued.getTime()),
                    amount: amount
            )

        when:
            controller.createInvoice(request)

        then:
            commandManager.createInvoice(
                    client,
                    phoneNumber,
                    Long.toString(issued.getTime()),
                    Long.toString(dueDate.getTime()),
                    amount
            )
    }
}
