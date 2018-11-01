package za.co.digitalplatoon.invoiceservices.invoice;

public class InvoiceNotFoundException extends RuntimeException {

    InvoiceNotFoundException(Long id) {
        super("Could not find invoice " + id);
    }
}
