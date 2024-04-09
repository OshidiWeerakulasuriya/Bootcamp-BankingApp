package Account;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    private final Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
        // Load accounts from file if exists
        loadAccountsFromFile("accounts.csv");
    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        try{
            validateAccountNumber(accountNumber);
            if (accounts.containsKey(accountNumber)) {
                System.out.println("Account already exists.");
                return;
            }
            BankAccount account = new BankAccount();
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully.");
        }
        catch (InvalidAccountNumberException e) {
            System.out.println("Error ");
        }

    }

    private void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if (!accountNumber.matches("^[a-zA-Z0-9]*$")) {
            throw new InvalidAccountNumberException("Please enter letters and numbers without special characters.");
        }
    }

    public void deposit() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();
            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Account doesn't exist.");
                return;
            }
            BankAccount account = accounts.get(accountNumber);
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
        }
        catch(Exception e){
            System.out.println("Error ");
        }
    }

    public void withdraw() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();
            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Account doesn't exist.");
                return;
            }
            BankAccount account = accounts.get(accountNumber);
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);
        }
        catch(Exception e){
            System.out.println("Error ");
        }
    }

    public void printBalance() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();
            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Account doesn't exist.");
                return;
            }
            BankAccount account = accounts.get(accountNumber);
            account.printBalance();
        }
        catch(Exception e){
            System.out.println("Error ");
        }

    }

    public void transfer() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter source account number: ");
            String sourceAccountNumber = scanner.nextLine();
            if (!accounts.containsKey(sourceAccountNumber)) {
                System.out.println("Source account doesn't exist.");
                return;
            }
            BankAccount sourceAccount = accounts.get(sourceAccountNumber);
            System.out.print("Enter destination account number: ");
            String destinationAccountNumber = scanner.nextLine();
            if (!accounts.containsKey(destinationAccountNumber)) {
                System.out.println("Destination account doesn't exist.");
                return;
            }
            BankAccount destinationAccount = accounts.get(destinationAccountNumber);
            System.out.print("Enter amount to transfer: ");
            double transferAmount = scanner.nextDouble();
            sourceAccount.transfer(transferAmount, destinationAccountNumber);
        }
        catch(Exception e){
            System.out.println("Error ");
        }
    }

    public void saveAccountsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue().getBalance());
            }
            System.out.println("Accounts saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving accounts to file: " + e.getMessage());
        }
    }

    public void loadAccountsFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String accountNumber = parts[0];
                    double balance = Double.parseDouble(parts[1]);
                    BankAccount account = new BankAccount(balance);
                    accounts.put(accountNumber, account);
                }
            }
            System.out.println("Accounts loaded from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Accounts file not found. Starting with no accounts.");
        }
    }

    public class InvalidAccountNumberException extends Exception {
        public InvalidAccountNumberException(String message) {
            super(message);
        }
    }

}
