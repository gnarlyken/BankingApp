import java.util.Scanner;

public class BankAccount {
    private String _id;
    private double _balance;


    //Sets a balance
    void set_balance(double balance){
        System.out.println();
        System.out.println("Balance info: ");
        _balance = balance;
    }
    //Returns a balance
    double get_balance(){

        return _balance;

    }
    //Deposit functionality
    public void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit: ");
        double amount = input.nextDouble();
        _balance = _balance + amount;
        System.out.println();
        System.out.println(amount + " euros was successfully deposited on your bank account. ");
        System.out.println("Total balance: " + _balance);

    }

    public  void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = input.nextDouble();
        if(_balance>=amount) {
            _balance = _balance - amount;
            System.out.println();
            System.out.println(amount + " euros was successfully withdrawn from your bank account. ");
            System.out.println("Total balance: " + _balance);
        }
        else {
            System.out.println("Insufficient funds");
        }
    }

    public  void printBalance(){
        System.out.println();
        System.out.println("Your current balance: " + _balance);
    }
    public void transfer(BankAccount targetAccount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (_balance >= amount) {
            _balance -= amount;
            targetAccount._balance += amount;
            System.out.println(amount + " euros transferred successfully.");
            System.out.println("Your remaining balance: " + _balance);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

}




