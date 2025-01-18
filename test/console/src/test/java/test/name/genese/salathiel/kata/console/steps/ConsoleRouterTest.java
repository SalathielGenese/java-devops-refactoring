package test.name.genese.salathiel.kata.console.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import name.genese.salathiel.kata.console.service.ConsoleRouter;
import name.genese.salathiel.kata.core.service.AccountService;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleRouterTest {
    private AccountService accountService;
    private ConsoleRouter router;

    @Given("my new account")
    public void my_new_account() {
        accountService = AccountService.from();
    }

    @Given("a console router with my account executed with input:")
    public void a_console_router_with_my_account_executed_with_input(String input) {
        ConsoleRouter.from(accountService, new Scanner(input)).route();
    }

    @Then("the balance is {bigdecimal}")
    public void the_balance_is(BigDecimal balance) {
        assertEquals(0, balance.compareTo(accountService.getBalance()));
    }
}
