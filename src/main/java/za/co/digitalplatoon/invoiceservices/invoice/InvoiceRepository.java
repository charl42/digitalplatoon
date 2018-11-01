package za.co.digitalplatoon.invoiceservices.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.digitalplatoon.invoiceservices.invoice.model.Invoice;

interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}