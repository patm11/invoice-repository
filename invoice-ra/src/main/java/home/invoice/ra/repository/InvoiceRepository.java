package home.invoice.ra.repository;

import home.invoice.ra.repository.model.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Invoice repository access configured to access a database
 *
 * @author patm11
 */
@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {

}
