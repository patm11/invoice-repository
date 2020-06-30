package home.invoice.ra.utility;

import home.invoice.ra.repository.InvoiceRepository;
import home.invoice.ra.repository.model.ClientEntity;
import home.invoice.ra.repository.model.InvoiceEntity;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Date;

/**
 * Loads data into the database when the application starts up
 *
 * @author patm11
 * Created on 6/29/20
 */
public class LocalDataLoaderUtility {

    private final InvoiceRepository repository;

    /**
     * Constructs an instance of the local data loader utility
     *
     * @param repository the invoice repository
     */
    public LocalDataLoaderUtility(InvoiceRepository repository) {
        this.repository = repository;
    }

    /**
     * Loads data into the application for testing
     */
    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setDue(new Date());
        invoiceEntity.setIssued(new Date());
        invoiceEntity.setAmount(22.56F);

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName("Bob Everts");
        clientEntity.setPhoneNumber("(555) 867-5309");

        invoiceEntity.setClient(clientEntity);

        repository.save(invoiceEntity);
    }
}
