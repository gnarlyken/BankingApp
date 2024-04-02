import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class AppTest {
@Test
    void shouldShowSimpleAssertion(){
    Assertions.assertEquals(1,1);
}

    @Test
    @DisplayName("Deposit Check")
    public void testDeposit() {
        BankAccount account = new BankAccount("1", "Renat", 100);
        InputStream inputStream = new ByteArrayInputStream("50\n".getBytes());
        Scanner scanner = new Scanner(inputStream);
        account.deposit(scanner);
        Assertions.assertEquals(150, account.getBalance());
    }
    @Test
    public void testWithdrawSufficientFunds() {
        BankAccount account = new BankAccount("1", "Renat", 200);
        InputStream inputStream = new ByteArrayInputStream("100\n".getBytes());
        Scanner scanner = new Scanner(inputStream);
        account.withdraw(scanner);
        Assertions.assertEquals(100, account.getBalance());
    }
    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("1", "Renat", 100);
        InputStream inputStream = new ByteArrayInputStream("150\n".getBytes());
        Scanner scanner = new Scanner(inputStream);
        account.withdraw(scanner); // Trying to withdraw more than balance
        Assertions.assertEquals(100, account.getBalance()); // Balance should remain unchanged
    }

    @Test
    public void testTransferSufficientFunds() {
        BankAccount sourceAccount = new BankAccount("1", "John", 200);
        BankAccount targetAccount = new BankAccount("2", "Alice", 100);
        sourceAccount.transfer(targetAccount, 50);
        Assertions.assertEquals(150, sourceAccount.getBalance());
        Assertions.assertEquals(150, targetAccount.getBalance());
    }


    @Test
    public void testTransferInsufficientFunds() {
        BankAccount sourceAccount = new BankAccount("1", "John", 100);
        BankAccount targetAccount = new BankAccount("2", "Alice", 200);
        sourceAccount.transfer(targetAccount, 150);

        // Balance should remain unchanged
        Assertions.assertEquals(100, sourceAccount.getBalance());
        Assertions.assertEquals(200, targetAccount.getBalance());
    }

    @Test
    public void testTransferToSelf() {
        BankAccount account = new BankAccount("1", "Renat", 200);
        account.transfer(account, 50); // Attempting to transfer to self
        Assertions.assertEquals(200, account.getBalance()); // Balance should remain unchanged
    }

}
