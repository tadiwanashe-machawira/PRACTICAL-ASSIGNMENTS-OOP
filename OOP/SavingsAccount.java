public class SavingsAccount extends Account {

    private double minimumBalance;
    private final double INTEREST_RATE = 0.05; // 5%

    // Constructor
    public SavingsAccount(String accountNumber, double balance,
                          double minimumBalance) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    // Override withdraw
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
        } else if (balance - amount < minimumBalance) {
            System.out.println("Savings withdrawal rejected: "
                    + "minimum balance of $" + minimumBalance
                    + " must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Savings withdrawal successful: $" + amount);
        }
    }

    // Override endOfMonth
    @Override
    public void endOfMonth() {
        double interest = balance * INTEREST_RATE;
        balance += interest;

        System.out.println("Savings interest added: $" + interest);
        System.out.println("Savings balance after month-end: $" + balance);
    }
}