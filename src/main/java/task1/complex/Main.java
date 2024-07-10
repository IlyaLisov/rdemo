package task1.complex;

import task1.complex.model.Transaction;
import task1.complex.model.User;
import task1.complex.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    private static final UserRepository repository = new UserRepository();

    public static void main(String[] args) {
        List<Transaction> transactions = getTransactions();
        processTransactions(transactions);
        List<User> users = repository.findAll();
        users.forEach(System.out::println);
    }

    public static List<Transaction> getTransactions() {
        return List.of(
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
    }

    public static void processTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            User user = repository.find(transaction.getUserId())
                    .orElse(new User(transaction.getUserId()));
            user.getStatus().updateBillingStatus(transaction);
            repository.save(user);
        }
    }

}
