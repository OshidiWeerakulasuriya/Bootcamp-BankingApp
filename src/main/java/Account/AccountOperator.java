package Account;
import java.util.Scanner;

public class AccountOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account1 = new BankAccount();
        Bank bank = new Bank();

        while (true) {
            try {
                System.out.println("\nSelect operation:");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Print Balance");
                System.out.println("5. Transfer to another account");
                System.out.println("6. Display All Accounts");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        bank.createAccount();
                        break;
                    case 2:
                        bank.deposit();
                        break;
                    case 3:
                        bank.withdraw();
                        break;
                    case 4:
                        bank.printBalance();
                        break;
                    case 5:
                        bank.transfer();
                        break;
                    case 6:
                        bank.saveAccountsToFile("accounts.csv");
                        System.out.println("Exiting the application.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            }
            catch (Exception e){
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                scanner.nextLine();
            }
        }
    }

}
