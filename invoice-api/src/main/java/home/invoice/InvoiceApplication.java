package home.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The invoice repository application
 *
 * @author patm11
 */
@SpringBootApplication
public class InvoiceApplication {

    /**
     * Starts the application
     *
     * @param args the args
     */
    public static void main(String[] args) {
        SpringApplication.run(InvoiceApplication.class, args);
    }
}
