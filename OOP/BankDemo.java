import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        // Create a list of Account references
        List<Account> accounts = new ArrayList<>();

        // Add different account types
        accounts.add(new SavingsAccount("S001", 1000.00, 500.00));
        accounts.add(new CurrentAccount("C001", 500.00, 300.00));
        accounts.add(new SavingsAccount("S002", 800.00, 400.00));
        accounts.add(new CurrentAccount("C002", 200.00, 500.00));

        System.out.println("===== BANK ACCOUNT DEMO =====");

        // Polymorphic loop
        for (Account account : accounts) {

            System.out.println("\nAccount: " + account.accountNumber);
            System.out.println("Starting balance: $"
                    + account.getBalance());

            // These methods are called through Account reference
            account.withdraw(700.00);

            System.out.println("Balance after withdrawal: $"
                    + account.getBalance());

            account.endOfMonth();

            System.out.println("Final balance: $"
                    + account.getBalance());
        }

        // Demonstrate deposit
        System.out.println("\n===== DEPOSIT TEST =====");

        Account account = new SavingsAccount("S003", 1000.00, 500.00);

        System.out.println("Initial balance: $"
                + account.getBalance());

        account.deposit(200.00);

        System.out.println("Balance after deposit: $"
                + account.getBalance());
    }
}