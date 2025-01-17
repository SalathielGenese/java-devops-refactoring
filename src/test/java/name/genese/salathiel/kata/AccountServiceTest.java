package name.genese.salathiel.kata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import name.genese.salathiel.kata.internal.AccountServiceDefault;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {
    private AccountService accountService;

    @Given("an initial balance of {double}")
    public void an_initial_balance_of(double amount) {
        accountService = new AccountServiceDefault(BigDecimal.valueOf(amount));
    }

    @When("doing a deposit of {double}")
    public void doing_a_deposit_of(double amount) {
        accountService.deposit(amount);
    }

    @When("make a withdrawal of {double}")
    public void make_a_withdrawal_of(double amount) {
        accountService.withdraw(amount);
    }

    @Then("my new balance is {bigdecimal}")
    public void my_new_balance_is(BigDecimal balance) {
        assertEquals(accountService.getBalance().compareTo(balance), 0);
    }
}
