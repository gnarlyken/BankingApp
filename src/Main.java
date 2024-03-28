/*
* Create a new project "Banking" and create a class "BankAccount" with property "balance" (should be decimal number)

create an empty default constructor for it
create a constructor with parameter for setting balance.
create a method "deposit" with one parameter "amount" (decimal number)
  which allows the user to increase the balance.
create a method "withdraw" with one parameter "amount"(decimal number) which allows the user to decrease the balance.
create a method "printBalance" which displays the current balance to user
method for transfer balance from one bank account to another

* Optionally make the program interactive with user e.g. using Scanner

* */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Map<String, BankAccount> accounts = new HashMap<>();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Print Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Generate a report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(accounts, scanner);
                    break;
                case 2:
                    deposit(accounts, scanner);
                    break;
                case 3:
                    withdraw(accounts, scanner);
                    break;
                case 4:
                    printBalance(accounts, scanner);
                    break;
                case 5:
                    transfer(accounts, scanner);
                    break;
                case 6:
                    generateReport(accounts);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void createAccount(Map<String, BankAccount> accounts, Scanner scanner) {
        System.out.println("Enter ID for the new account: ");
        String id = scanner.next();
        if (accounts.containsKey(id)) {
            System.out.println("Account with this ID already exists.");
        } else {
            System.out.println("Enter name for the account: ");
            String name = scanner.next();
            System.out.println("Enter initial balance for the account: ");
            double initialBalance = scanner.nextDouble();
            BankAccount account = new BankAccount(id, name, initialBalance);
            accounts.put(id, account);
            System.out.println("Account created successfully!");
        }
    }

    private static void deposit(Map<String, BankAccount> accounts, Scanner scanner) {
        System.out.println("Enter account ID to deposit: ");
        String id = scanner.next();
        BankAccount account = accounts.get(id);
        if (account != null) {
            account.deposit(scanner);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Map<String, BankAccount> accounts, Scanner scanner) {
        System.out.println("Enter account ID to withdraw: ");
        String id = scanner.next();
        BankAccount account = accounts.get(id);
        if (account != null) {
            account.withdraw(scanner);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void printBalance(Map<String, BankAccount> accounts, Scanner scanner) {
        System.out.println("Enter account ID to print balance: ");
        String id = scanner.next();
        BankAccount account = accounts.get(id);
        if (account != null) {
            account.printBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void transfer(Map<String, BankAccount> accounts, Scanner scanner) {
        System.out.println("Enter source account ID: ");
        String sourceId = scanner.next();
        System.out.println("Enter target account ID: ");
        String targetId = scanner.next();
        BankAccount sourceAccount = accounts.get(sourceId);
        BankAccount targetAccount = accounts.get(targetId);
        if (sourceAccount != null && targetAccount != null) {
            System.out.println("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            sourceAccount.transfer(targetAccount, amount);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }
    private static void generateReport(Map<String, BankAccount> accounts) {
        try {
            FileWriter writer = new FileWriter("account_report.txt");
            for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
                BankAccount account = entry.getValue();
                writer.write("Account ID: " + account.getId() + "\n");
                writer.write("Account Name: " + account.getName() + "\n");
                writer.write("Balance: " + account.getBalance() + "\n\n");
            }
            writer.close();
            System.out.println("Account report generated successfully.");
        } catch (IOException e) {
            System.out.println("Error writing account report to file.");
            e.printStackTrace();
        }
    }
}

