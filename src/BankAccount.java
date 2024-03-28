import java.util.Scanner;

public class BankAccount {
    private String id;
    private String name;
    private double balance;

    public BankAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(Scanner scanner) {
        System.out.println("Enter the amount you want to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println(amount + " euros was successfully deposited on account " + id + ". ");
        System.out.println("Total balance: " + balance);
    }

    public void withdraw(Scanner scanner) {
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = scanner.nextDouble();
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " euros was successfully withdrawn from account " + id + ". ");
            System.out.println("Total balance: " + balance);
        } else {
            System.out.println("Insufficient funds on account " + id);
        }
    }

    public void printBalance() {
        System.out.println("Account ID: " + id);
        System.out.println("Account Name: " + name);
        System.out.println("Current balance: " + balance);
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            targetAccount.balance += amount;
            System.out.println(amount + " euros transferred successfully from account " + id + " to account " + targetAccount.id);
            System.out.println("Your remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds for transfer from account " + id);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }



}




