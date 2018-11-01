package za.co.digitalplatoon.invoiceservices.invoice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data

public class Invoice {

    @Id
    @GeneratedValue
    @NotNull
    private long id;
    private String client;
    private Long vatRate;
    private Date invoiceDate;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "invoice",cascade = CascadeType.ALL)

    private List<LineItem> lineItems;

    Invoice(String client, Long vatRate, Date invoiceDate) {
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
    }
}