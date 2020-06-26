package home.invoice.ra.engine.impl;

import home.invoice.model.Invoice;
import home.invoice.ra.engine.MappingEngine;
import home.invoice.ra.repository.InvoiceRepository;
import home.invoice.ra.repository.model.InvoiceEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The implementation of the mapping engine which can
 * convert JPA entities into the common data models and
 * back
 *
 * @author patm11
 * Created on 4/13/20
 */
@Component
public class MappingEngineImpl implements MappingEngine {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public MappingEngineImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice map(InvoiceEntity entity) {
        Invoice invoice = new Invoice();

        invoice.setId(Long.toString(entity.getId()));
        invoice.setAmount(entity.getAmount().doubleValue());
        invoice.setClient(entity.getClient().getName());
        invoice.setDue(entity.getDue());
        invoice.setIssued(entity.getIssued());

        return invoice;
    }

    @Override
    public InvoiceEntity map(Invoice model) {
        InvoiceEntity entity;

        if(StringUtils.isNotBlank(model.getId())) {
            Optional<InvoiceEntity> optional = invoiceRepository.findById(Long.parseLong(model.getId()));

            entity = optional.orElse(null);
        } else {
            entity = new InvoiceEntity();
            entity.setAmount(model.getAmount().floatValue());
            entity.setIssued(model.getIssued());
            entity.setDue(model.getDue());
            // entity.setClient(); // TODO: get client by name - if not exists, create a new client entity
        }

        return entity;
    }
}
