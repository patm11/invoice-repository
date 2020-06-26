package home.invoice.ra;

import home.invoice.ra.engine.ValidationEngine;
import home.invoice.ra.engine.impl.ValidationEngineImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configures the invoice repository application
 *
 * @author patm11
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class InvoiceRepositoryConfiguration {

    /**
     * Provides the validation engine bean
     *
     * @return the validation engine bean
     */
    @Bean
    public ValidationEngine validationEngine() {
        return new ValidationEngineImpl();
    }

}
