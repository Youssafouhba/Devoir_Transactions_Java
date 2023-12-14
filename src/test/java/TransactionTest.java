import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class TransactionTest {
    @Test
    public void getTypeVirRestTest() {
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");

        Bank bank1 = new Bank("Bank A");
        Bank bank2 = new Bank("Bank B");
        Account account1 = new Account(customer1,20000,bank1);
        Account account2 = new Account(customer2,3000,bank1);
        Transaction transaction1 = new Transaction(account1, account2, 200.0);
        Assertions.assertEquals("virRest", transaction1.getType(), "Invalid transaction type");
    }
    @Test
    public void getTypeVirIntTest() {
        Customer customer1 = new Customer("Customer 1");

        Bank bank1 = new Bank("Bank A");
        Bank bank2 = new Bank("Bank B");
        Account account1 = new Account(customer1,2000,bank1);
        Account account2 = new Account(customer1,2000,bank2);
        Transaction transaction1 = new Transaction(account1, account2, 200.0);
        Assertions.assertEquals("virInt", transaction1.getType(), "Invalid transaction type");
    }
    @Test
    public void getTypeVirChaTest() {
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");

        Bank bank1 = new Bank("Bank A");
        Bank bank2 = new Bank("Bank B");
        Account account1 = new Account(customer1,2000,bank1);
        Account account2 = new Account(customer2,2000,bank2);
        Transaction transaction1 = new Transaction(account1, account2, 200.0);
        Assertions.assertEquals("virCha", transaction1.getType(), "Invalid transaction type");
    }
    @Test
    public void TransactionDecisionTest(){
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Bank bank1 = new Bank("Bank A");
        Bank bank2 = new Bank("Bank B");
        Account account1 = new Account(customer1,2000,bank1);
        Account account2 = new Account(customer2,2000,bank2);
        Transaction transaction1 = new Transaction(account1, account2, 200.0);
        TransactionStatus status = TransactionStatus.APPROVED;
        Assertions.assertEquals(status,transaction1.TransactionDecision());
    }
    @Test
    public void isFullyApprovedTest(){
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Bank bank1 = new Bank("Bank A");
        Bank bank2 = new Bank("Bank B");
        Account account1 = new Account(customer1,2000000000,bank1);
        Account account2 = new Account(customer2,2000,bank2);
        Transaction transaction1 = new Transaction(account1, account2, 2000000.0);
        Assertions.assertFalse(transaction1.isFullyApproved());
    }
    @Test
    public void setStatusTest(){
        Customer customer1 = new Customer("Customer 1");
        Bank bank1 = new Bank("Bank A");
        Account account1 = new Account(customer1,2000000000,bank1);
        Transaction transaction1 = new Transaction(account1, account1, 2000000.0);
        TransactionStatus s=TransactionStatus.APPROVED;
        transaction1.setStatus(s);
        Assertions.assertEquals(s,transaction1.getStatus());

    }

}
