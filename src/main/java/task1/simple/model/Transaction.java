package task1.simple.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {

    private Long userId;
    private BigDecimal adDeliveryPennies;
    private BigDecimal paymentPennies;
    private long transactionTimestamp;

}

