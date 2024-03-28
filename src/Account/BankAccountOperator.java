package Account;

import java.util.Scanner;

public class BankAccountOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account1 = new BankAccount();

        while (true) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Balance");
            System.out.println("4. Transfer to another account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account1.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Your Balance is: ");
                    account1.printBalance();
                    break;
                case 4:
                    System.out.println("Amount you need to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    account1.transfer(transferAmount);
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

}
