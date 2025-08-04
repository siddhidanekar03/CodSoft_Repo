import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdrawUI();
                    break;
                case 2:
                    depositUI();
                    break;
                case 3:
                    checkBalanceUI();
                    break;
                case 4:
                    System.out.println("Thank you ");
                    break;
                default:
                    System.out.println(" Invalid choice.");
            }
        } while (choice != 4);
    }

    private void withdrawUI() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    private void depositUI() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void checkBalanceUI() {
        System.out.printf(" Current Balance: %.2f\n", account.getBalance());
    }
    
    public static void main(String[] args) {
        
        BankAccount myAccount = new BankAccount(1000);
        ATM atm = new ATM(myAccount);
        atm.start();
    }


}
