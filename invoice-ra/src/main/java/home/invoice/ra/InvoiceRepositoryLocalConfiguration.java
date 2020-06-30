package home.invoice.ra;

import home.invoice.ra.repository.InvoiceRepository;
import home.invoice.ra.utility.LocalDataLoaderUtility;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configures beans for use in the local profile
 *
 * @author patm11
 * Created on 6/29/20
 */
@Profile("local")
@Configuration
public class InvoiceRepositoryLocalConfiguration {

    /**
     * Creates a local data loader utility bean
     *
     * @param invoiceRepository the invoice repository
     * @return the local data loader utility bean
     */
    @Bean
    public LocalDataLoaderUtility localDataLoaderUtility(InvoiceRepository invoiceRepository) {
        return new LocalDataLoaderUtility(invoiceRepository);
    }
}
