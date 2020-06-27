package home.invoice.ra.manager.impl;

import home.invoice.model.Invoice;
import home.invoice.ra.engine.MappingEngine;
import home.invoice.ra.engine.ValidationEngine;
import home.invoice.ra.engine.validation.InvoiceViolation;
import home.invoice.ra.exception.InvoiceRepositoryBadRequestException;
import home.invoice.ra.exception.InvoiceRepositoryNotFoundException;
import home.invoice.ra.manager.InvoiceQueryManager;
import home.invoice.ra.repository.InvoiceRepository;
import home.invoice.ra.repository.model.InvoiceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Query manager implementation for invoice retrieval
 *
 * @author patm11
 */
@Component
public class InvoiceQueryManagerImpl implements InvoiceQueryManager {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceQueryManagerImpl.class);

    private final ValidationEngine validationEngine;
    private final MappingEngine mappingEngine;
    private final InvoiceRepository invoiceRepository;

    /**
     * Constructs an instance of the invoice query manager
     *
     * @param validationEngine  the validation engine
     * @param mappingEngine the mapping engine
     * @param invoiceRepository the invoice repository
     */
    @Autowired
    public InvoiceQueryManagerImpl(ValidationEngine validationEngine, MappingEngine mappingEngine, InvoiceRepository invoiceRepository) {
        this.validationEngine = validationEngine;
        this.mappingEngine = mappingEngine;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findInvoicesByCriteria(Map<String, String> criteria) {
        // TODO: create a criteria resolver that produces a specification, extend the repository to use the specification repository
        return null;
    }

    @Override
    public Invoice getInvoiceById(String id) {
        Set<InvoiceViolation> violations = validationEngine.validateInvoiceId(id);

        if (!violations.isEmpty()) {
            violations.forEach(violation -> LOG.info(violation.getMessage()));
            throw new InvoiceRepositoryBadRequestException("Invalid ID provided");
        }

        Optional<InvoiceEntity> entity = invoiceRepository.findById(Long.parseLong(id));

        if(!entity.isPresent()) {
            throw new InvoiceRepositoryNotFoundException("Invoice for ID " + id + " not found");
        }

        return mappingEngine.map(entity.get());
    }
}
