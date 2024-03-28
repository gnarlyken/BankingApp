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


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //All users
        BankAccount user = new BankAccount();
        BankAccount user2 = new BankAccount();

        System.out.println("Enter initial balance for user 1: ");
        double initialBalanceUser = scanner.nextDouble();
        user.set_balance(initialBalanceUser);

        System.out.println("Enter initial balance for user 2: ");
        double initialBalanceUser2 = scanner.nextDouble();
        user2.set_balance(initialBalanceUser2);

        while(true){
            System.out.println("\n Choose an option: ");
            System.out.println("1. Deposit ");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Balance");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the user (1 or 2): ");
                    int userChoice = scanner.nextInt();
                    if (userChoice == 1) {
                        user.deposit();
                    } else if (userChoice == 2) {
                        user2.deposit();
                    } else {
                        System.out.println("Invalid user choice.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the user (1 or 2): ");
                    int userChoiceWithdraw = scanner.nextInt();
                    if (userChoiceWithdraw == 1) {
                        user.withdraw();
                    } else if (userChoiceWithdraw == 2) {
                        user2.withdraw();
                    } else {
                        System.out.println("Invalid user choice.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the user (1 or 2): ");
                    int userChoicePrint = scanner.nextInt();
                    if (userChoicePrint == 1) {
                        user.printBalance();
                    } else if (userChoicePrint == 2) {
                        user2.printBalance();
                    } else {
                        System.out.println("Invalid user choice.");
                    }
                    break;
                case 4:
                    System.out.print("Enter source user (1 or 2): ");
                    int sourceUser = scanner.nextInt();
                    System.out.print("Enter target user (1 or 2): ");
                    int targetUser = scanner.nextInt();
                    if (sourceUser == 1 && targetUser == 2) {
                        user.transfer(user2);
                    } else if (sourceUser == 2 && targetUser == 1) {
                        user2.transfer(user);
                    } else {
                        System.out.println("Invalid user choice.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }






    }
}
