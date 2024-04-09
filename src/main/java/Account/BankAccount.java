package Account;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    Scanner scanner = new Scanner(System.in);
    private double balance;
    private static ArrayList<BankAccount> accounts = new ArrayList<>();

    public BankAccount() {
        // Initialize balance to 0
        this.balance = 0.0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Cannot deposit amount less than 0.");
            }
            // Add the amount to the current balance
            balance = balance + amount;
            System.out.println("Deposited amount: " + amount);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error ");
        }
    }

    // Method to withdraw amount from the account
    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Enter legal value.");
            }
            // Check if sufficient balance is available
            if (balance >= amount) {
                // Subtract the amount from the current balance
                balance = balance - amount;
                System.out.println("Withdrawn amount: " + amount);
            } else {
                System.out.println("Sorry, Insufficient balance.");
            }
        }
        catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error ");
        }
    }

    // Method to print current balance
    public void printBalance() {

        System.out.println("Your Current Balance: " + this.balance);
    }

    // Transfer amount from one account to another
    public void transfer(double amount, String destinationAccountNumber) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Transfer amount must be legal value.");
            }
            // Checking is there sufficient amount to transfer
            if (this.balance >= amount) {
                // Withdraw amount from source account
                withdraw(amount);
                // Deposit amount to destination account
                System.out.println("Transferred " + amount + " to " + destinationAccountNumber + " account.");
            } else {
                System.out.println("Insufficient balance for transfer.");
            }
        }
        catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error ");
        }
    }

    public double getBalance() {
        return this.balance;
    }
}
