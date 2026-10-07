
public abstract class Account {
    protected String accountNumber;
    protected double balance;

    // Constructor
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Concrete deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive.");
        } else {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    // Concrete getBalance method
    public double getBalance() {
        return balance;
    }

    // Abstract methods
    public abstract void withdraw(double amount);

    public abstract void endOfMonth();
}