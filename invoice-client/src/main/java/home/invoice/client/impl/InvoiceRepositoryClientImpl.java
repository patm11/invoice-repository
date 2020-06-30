package home.invoice.client.impl;

import feign.Feign;
import home.invoice.client.InvoiceRepositoryClient;
import home.invoice.client.feign.InvoiceRepositoryFeignClient;
import home.invoice.model.Invoice;

/**
 * Implementation of the invoice repository client which helps to encourage
 * good inputs and handle cases where requests need to be built in specific
 * ways
 *
 * @author patm11
 * Created on 6/28/20
 */
public class InvoiceRepositoryClientImpl implements InvoiceRepositoryClient {

    private final InvoiceRepositoryFeignClient client;

    /**
     * Constructs an instance of the invoice repository client given the url
     *
     * @param url the base url
     */
    public InvoiceRepositoryClientImpl(String url) {
        this.client = InvoiceRepositoryFeignClient.buildClient(url);
    }

    /**
     * Constructs an instance of the invoice repository client given the url
     * and a Feign builder
     *
     * @param url the base url
     * @param builder the Feign builder
     */
    public InvoiceRepositoryClientImpl(String url, Feign.Builder builder) {
        this.client = InvoiceRepositoryFeignClient.buildClient(url, builder);
    }

    /**
     * Constructs an instance given an already provided instance of the Feign client
     * Intended to be used in unit tests
     *
     * @param client the Feign client
     */
    protected InvoiceRepositoryClientImpl(InvoiceRepositoryFeignClient client) {
        this.client = client;
    }

    @Override
    public Invoice getInvoice(long id) {
        return client.getInvoice(Long.toString(id));
    }
}
