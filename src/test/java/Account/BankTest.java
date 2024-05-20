package Account;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

class BankTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream originalIn = (ByteArrayInputStream) System.in;
    private final PrintStream originalOut = System.out;

    private Bank bank;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        bank = new Bank();
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testCreateAccountSuccessfully() {
        String input = "123456\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        bank.createAccount();

        Map<String, BankAccount> accounts = bank.accounts;
        Assertions.assertTrue(accounts.containsKey("123456"));
        Assertions.assertEquals("Account created successfully.\n", outContent.toString());
    }

    @Test
    public void testCreateAccountWithExistingAccountNumber() {
        String input = "123456\n123456\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        bank.createAccount();
        outContent.reset(); // clear the output
        bank.createAccount();

        Assertions.assertEquals("Account already exists.\n", outContent.toString());
    }

    @Test
    public void testCreateAccountWithInvalidAccountNumber() {
        String input = "123456!\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        bank.createAccount();

        Assertions.assertEquals("Error \n", outContent.toString());
    }

    @Test
    void deposit() {

    }

    @Test
    void withdraw() {
    }

    @Test
    void printBalance() {
    }
}