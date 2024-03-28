package Account;

public class BankAccount {
    private double balance;
    public BankAccount() {
        // Initialize balance to 0
        balance = 0.0;
    }

    public void deposit(double amount) {
        // Add the amount to the current balance
        balance = balance + amount;
        System.out.println("Deposited amount: " + amount);
    }

    // Method to withdraw amount from the account
    public void withdraw(double amount) {
        // Check if sufficient balance is available
        if (balance >= amount) {
            // Subtract the amount from the current balance
            balance = balance - amount;
            System.out.println("Withdrawn amount: " + amount);
        } else {
            System.out.println("Sorry, Insufficient balance.");
        }
    }

    // Method to print current balance
    public void printBalance() {
        System.out.println("Your Current Balance: " + balance);
    }

    // Transfer amount from one account to another
    public void transfer(BankAccount destinationAccount, double amount) {
        // Checking is there sufficient amount to transfer
        if (balance >= amount) {
            // Withdraw amount from source account
            withdraw(amount);
            // Deposit amount to destination account
            destinationAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to another account.");
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

}
