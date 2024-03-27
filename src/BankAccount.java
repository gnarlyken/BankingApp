public class BankAccount {
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
    public void deposit(double amount) {
        _balance = _balance + amount;
        System.out.println();
        System.out.println(amount + " euros was successfully deposited on your bank account. ");
        System.out.println("Total balance: " + _balance);

    }

    public  void withdraw(double amount) {
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

    public void transfer(BankAccount recipient, double amount) {
        if (_balance >= amount) {
            _balance -= amount; // Deduct the amount from sender's balance
            recipient.deposit(amount); // Deposit the amount to recipient's account
            System.out.println();
            System.out.println(amount + " euros was successfully transferred to recipient's bank account.");
            System.out.println("Your updated balance: " + _balance);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }



}




