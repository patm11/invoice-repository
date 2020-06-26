package home.invoice.ra.manager.impl;

import home.invoice.model.Invoice;
import home.invoice.ra.engine.ValidationEngine;
import home.invoice.ra.engine.validation.InvoiceViolation;
import home.invoice.ra.manager.InvoiceQueryManager;
import home.invoice.ra.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Query manager implementation for invoice retrieval
 *
 * @author patm11
 */
@Component
public class InvoiceQueryManagerImpl implements InvoiceQueryManager {

    private final ValidationEngine validationEngine;
    private final InvoiceRepository invoiceRepository;

    /**
     * Constructs an instance of the invoice query manager
     *
     * @param invoiceRepository the invoice repository
     * @param validationEngine  the validation engine
     */
    @Autowired
    public InvoiceQueryManagerImpl(InvoiceRepository invoiceRepository, ValidationEngine validationEngine) {
        this.validationEngine = validationEngine;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findInvoicesByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public Invoice getInvoiceById(String id) {
        Set<InvoiceViolation> violations = validationEngine.validateInvoiceId(id);

        if (!violations.isEmpty()) {
            // TODO: throw exception
        }

        invoiceRepository.findById(Long.parseLong(id));

        return null;
    }
}
