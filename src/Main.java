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



public class Main {
    public static void main(String[] args) {
        //First user
        BankAccount user = new BankAccount();
        user.set_balance(0);
        System.out.println(user.get_balance());

        user.deposit(1000);
        user.withdraw(50);

        user.printBalance();
        //Second user
        BankAccount user2 = new BankAccount();
        user2.set_balance(500);
        System.out.println(user2.get_balance());;

        //user to user2 transfer
        double transferAmount = 200;
        user.transfer(user2, transferAmount);


        //the balances after the transfer
        System.out.println();
        System.out.println("After transfer:");
        System.out.println("User 1 balance: " + user.get_balance());
        System.out.println("User 2 balance: " + user2.get_balance());





    }
}




