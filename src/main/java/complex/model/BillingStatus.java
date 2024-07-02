package complex.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class BillingStatus {

    private BigDecimal adDeliveryPennies;
    private BigDecimal adImpressionsPennies;

    public BillingStatus() {
        this.adDeliveryPennies = BigDecimal.ZERO;
        this.adImpressionsPennies = BigDecimal.ZERO;
    }

    public void updateBillingStatus(
            Transaction transaction
    ) {
        this.adDeliveryPennies = this.adDeliveryPennies.add(transaction.getAdDeliveryPennies());
        this.adImpressionsPennies = this.adImpressionsPennies.add(transaction.getPaymentPennies());
    }

}
