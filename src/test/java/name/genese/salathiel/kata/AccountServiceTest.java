package name.genese.salathiel.kata;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import name.genese.salathiel.kata.internal.AccountServiceDefault;

public class AccountServiceTest {
    private AccountService accountService;
    private double amount;

    @Before
    public void setUp() {
        accountService = new AccountServiceDefault();
    }

    @Given("an amount {double}")
    public void an_amount(double amount) {
        this.amount = amount;
    }

    @When("doing a deposit")
    public void doing_a_deposit() {
        accountService.deposit(amount);
    }

    @Then("my balance is increased by {double}")
    public void my_balance_is_increase_by(double amount) {
    }

    @When("make a withdrawal")
    public void make_a_withdrawal() {
        accountService.deposit(amount);
    }

    @Then("my balance is decreased by {double}")
    public void my_balance_is_decrease_by(double amount) {
    }
}
