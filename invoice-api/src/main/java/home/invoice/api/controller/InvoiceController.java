package home.invoice.api.controller;

import home.invoice.model.Invoice;
import home.invoice.ra.manager.InvoiceCommandManager;
import home.invoice.ra.manager.InvoiceQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceQueryManager queryManager;
    private final InvoiceCommandManager commandManager;

    @Autowired
    public InvoiceController(InvoiceQueryManager queryManager, InvoiceCommandManager commandManager) {
        this.queryManager = queryManager;
        this.commandManager = commandManager;
    }

    @GetMapping
    public List<Invoice> findInvoicesByCriteria(@RequestParam Map<String, String> params) {
        return queryManager.findInvoicesByCriteria(params);
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable("id") String id) {
        return queryManager.getInvoiceById(id);
    }
}
