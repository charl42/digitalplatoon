package za.co.digitalplatoon.invoiceservices.invoice.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Data
public class LineItem {
    @Id
    @GeneratedValue
    private long id;
    private Long quantity;
    private String description;
    private BigDecimal unitPrice;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "invoice_id")

    private Invoice invoice;

    public LineItem(){    }
    public BigDecimal getTotal()
    {
        BigDecimal total = BigDecimal.ZERO;

        total = this.unitPrice.multiply(new BigDecimal(quantity));

        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
