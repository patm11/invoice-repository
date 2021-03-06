package home.invoice.ra.manager.impl;

import home.invoice.ra.manager.InvoiceCommandManager;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Responsible for sending write commands to the repository level
 *
 * @author patm11
 */
@Component
public class InvoiceCommandManagerImpl implements InvoiceCommandManager {

    @Override
    public void createInvoice(String client, Date issued, Date due, Double amount) {

    }

    @Override
    public void saveInvoice(String id, Date due, Double amount) {

    }

    @Override
    public void deleteInvoice(String id) {

    }
}
