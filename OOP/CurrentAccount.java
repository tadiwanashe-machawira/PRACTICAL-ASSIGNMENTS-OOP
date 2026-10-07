public class CurrentAccount extends Account {

    private double overdraftLimit;
    private final double MONTHLY_FEE = 10.00;

    // Constructor
    public CurrentAccount(String accountNumber, double balance,
                          double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
        } else if (balance - amount < -overdraftLimit) {
            System.out.println("Current withdrawal rejected: "
                    + "overdraft limit of $" + overdraftLimit
                    + " would be exceeded.");
        } else {
            balance -= amount;
            System.out.println("Current withdrawal successful: $" + amount);

            if (balance < 0) {
                System.out.println("Account is now in overdraft: $" + balance);
            }
        }
    }

    // Override endOfMonth
    @Override
    public void endOfMonth() {
        balance -= MONTHLY_FEE;

        System.out.println("Monthly maintenance fee deducted: $"
                + MONTHLY_FEE);
        System.out.println("Current balance after month-end: $" + balance);
    }
}