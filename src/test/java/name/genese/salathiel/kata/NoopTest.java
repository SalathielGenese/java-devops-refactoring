package name.genese.salathiel.kata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoopTest {
    private final Function<String, String> hello = "Hello, %s!"::formatted;
    private String greeting;
    private String name;

    @Given("a name {string}")
    public void aName(String name) {
        this.name = name;
    }

    @When("hello method is called with name")
    public void whenHelloMethodIsCalled() {
        greeting = hello.apply(name);
    }

    @Then("A hello + name string is returned")
    public void thenAHelloMethodIsCalled() {
        assertEquals(greeting, "Hello, %s!".formatted(name));
    }
}
