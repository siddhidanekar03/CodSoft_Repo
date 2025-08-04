public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0)
            this.balance = 0;
        else
            this.balance = initialBalance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Enter positive value.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            balance -= amount;
            System.out.println(" Withdrawal successful.");
            return true;
        }
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;
        } else {
            balance += amount;
            System.out.println("Deposit successful.");
            return true;
        }
    }

    public double getBalance() {
        return balance;
    }
}

