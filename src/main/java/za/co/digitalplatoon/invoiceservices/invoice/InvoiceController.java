package za.co.digitalplatoon.invoiceservices.invoice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.*;
import za.co.digitalplatoon.invoiceservices.invoice.model.Invoice;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class InvoiceController {
    private final InvoiceRepository repository;

    InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/invoices")
    public List<Invoice> viewAllInvoices()
    {
        log.info("Display all invoices");
        return repository.findAll();
    }

    @GetMapping("/invoices/{id}")
    public Optional<Invoice> viewInvoice(@PathVariable Long id)
    {
        log.info("Display invoice: {}",id);
        return repository.findById(id)
                /*.orElseThrow(() -> new InvoiceNotFoundException(id))*/;
    }

    @PostMapping("/invoices")
    Invoice addInvoice(@RequestBody Invoice newInvoice) throws IOException, ParseException
    {
        log.info("Adding invoices");
        return repository.save(newInvoice);
    }
}
