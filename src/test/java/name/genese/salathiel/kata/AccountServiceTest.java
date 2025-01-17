package name.genese.salathiel.kata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import name.genese.salathiel.kata.internal.AccountServiceDefault;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    private AccountService accountService;
    private Exception givenException;
    private Exception whenException;

    @BeforeEach
    public void setUp() {
        accountService = null;
        givenException = null;
        whenException = null;
    }

    @Given("a balance of -1")
    public void a_balance_of_neg_1() {
        // @formatter:off
        try { accountService = new AccountServiceDefault(BigDecimal.valueOf(-1)); }
        catch (Exception e) { givenException = e; }
        // @formatter:on
    }

    @Given("a balance of null")
    public void a_balance_of_null() {
        // @formatter:off
        try { accountService = new AccountServiceDefault(null); }
        catch (Exception e) { givenException = e; }
        // @formatter:on
    }

    @Given("an initial balance of {bigdecimal}")
    public void an_initial_balance_of(BigDecimal initial) {
        accountService = new AccountServiceDefault(initial);
    }

    @When("making a withdrawal of {double}")
    public void making_a_withdrawal_of(double amount) {
        // @formatter:off
        try { accountService.withdraw(amount); }
        catch (Exception e) { whenException = e; }
        // @formatter:on
    }

    @When("making a deposit of {double}")
    public void making_a_deposit_of(double amount) {
        // @formatter:off
        try { accountService.deposit(amount); }
        catch (Exception e) { whenException = e; }
        // @formatter:on
    }

    @Then("fail null initialization")
    public void fail_null_initialization() {
        assertNull(accountService);
        assertInstanceOf(NullPointerException.class, givenException);
    }

    @Then("fail negative initialization")
    public void fail_negative_initialization() {
        assertNull(accountService);
        assertInstanceOf(IllegalArgumentException.class, givenException);
    }

    @Then("balance is {bigdecimal}")
    public void balance_is(BigDecimal balance) {
        assertEquals(0, accountService.getBalance().compareTo(balance));
    }

    @Then("fail with {string}")
    public void fail_with(String message) {
        assertInstanceOf(IllegalArgumentException.class, whenException);
        assertEquals(whenException.getMessage(), message);
    }
}
