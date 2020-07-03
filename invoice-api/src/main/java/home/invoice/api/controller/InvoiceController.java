package home.invoice.api.controller;

import home.invoice.model.Invoice;
import home.invoice.model.NewInvoiceRequest;
import home.invoice.ra.manager.InvoiceCommandManager;
import home.invoice.ra.manager.InvoiceQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Web controller for invoice repository access requests
 *
 * @author patm11
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceQueryManager queryManager;
    private final InvoiceCommandManager commandManager;

    /**
     * Constructs the invoice controller
     *
     * @param queryManager the query manager
     * @param commandManager the command manager
     */
    @Autowired
    public InvoiceController(InvoiceQueryManager queryManager, InvoiceCommandManager commandManager) {
        this.queryManager = queryManager;
        this.commandManager = commandManager;
    }

    /**
     * Finds a set of invoices given a varying collection of criteria to search by
     *
     * @param params the search parameters/criteria
     * @return the invoices satisfying the criteria
     */
    @GetMapping
    public List<Invoice> findInvoicesByCriteria(@RequestParam Map<String, String> params) {
        return queryManager.findInvoicesByCriteria(params);
    }

    /**
     * Retrieves a single invoice given its id
     *
     * @param id the invoice id
     * @return the invoice with the matching id
     */
    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable("id") String id) {
        return queryManager.getInvoiceById(id);
    }

    /**
     * Creates a new invoice with the data in the request
     *
     * @param request the request
     */
    @PostMapping
    public void createInvoice(@RequestBody NewInvoiceRequest request) {
        commandManager.createInvoice(
                request.getClientName(),
                request.getPhoneNumber(),
                request.getIssued(),
                request.getDue(),
                request.getAmount()
        );
    }
}
