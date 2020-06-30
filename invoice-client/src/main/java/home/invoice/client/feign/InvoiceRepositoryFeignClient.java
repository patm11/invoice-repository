package home.invoice.client.feign;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import home.invoice.model.Invoice;

/**
 * Feign client capable of calling the invoice repository's RESTful endpoints
 *
 * @author patm11
 * Created on 6/28/20
 */
public interface InvoiceRepositoryFeignClient {

    /**
     * Gets an invoice from the invoice repository service given an id
     *
     * @param id the invoice id
     * @return the invoice
     */
    @RequestLine("GET /invoice/{id}")
    Invoice getInvoice(@Param("id") String id);

    /**
     * Configures an instance of this Feign client given the base url of the
     * service
     *
     * @param url the base url
     * @return the invoice repository feign client
     */
    static InvoiceRepositoryFeignClient buildClient(String url) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(InvoiceRepositoryFeignClient.class, url);
    }

    /**
     * Configures an instance of this Feign client given the url and a
     * Feign builder to allow for other Feign options to be set
     *
     * @param url the base url
     * @param builder the Feign Builder
     * @return the invoice repository Feign client
     */
    static InvoiceRepositoryFeignClient buildClient(String url, Feign.Builder builder) {
        return builder.target(InvoiceRepositoryFeignClient.class, url);
    }
}
