package task1.simple;

import task1.simple.model.BillingStatus;
import task1.simple.model.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(
                        1L,
                        BigDecimal.valueOf(1000),
                        BigDecimal.ZERO,
                        1500000001L
                ),
                new Transaction(
                        1L,
                        BigDecimal.valueOf(1000),
                        BigDecimal.ZERO,
                        1500000002L
                ),
                new Transaction(
                        1L,
                        BigDecimal.ZERO,
                        BigDecimal.valueOf(500),
                        1500000003L
                ),
                new Transaction(
                        1L,
                        BigDecimal.valueOf(1000),
                        BigDecimal.valueOf(500),
                        1500000004L
                )
        );

        Map<Long, BillingStatus> users = processTransactions(transactions);
        users.forEach((userId, billingStatus) -> {
            System.out.println("User ID: " + userId);
            System.out.println("Ad delivery pennies: " + billingStatus.getAdDeliveryPennies());
            System.out.println("Ad impressions pennies: " + billingStatus.getAdImpressionsPennies());
            System.out.println();
        });
    }

    public static Map<Long, BillingStatus> processTransactions(List<Transaction> transactions) {
        Map<Long, BillingStatus> users = new HashMap<>();
        for (Transaction transaction : transactions) {
            BillingStatus status = users.getOrDefault(
                    transaction.getUserId(),
                    new BillingStatus()
            );
            status.updateBillingStatus(transaction);
            users.put(
                    transaction.getUserId(),
                    status
            );
        }
        return users;
    }

}
