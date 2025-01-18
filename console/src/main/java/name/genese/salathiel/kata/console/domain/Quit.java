package name.genese.salathiel.kata.console.domain;

import name.genese.salathiel.kata.core.service.AccountService;

import java.util.Scanner;
import java.util.function.Consumer;

public record Quit() implements Command {
    @Override
    public Command visit(AccountService accountService, Consumer<Exception> onError, Scanner scanner) {
        System.err.println("""
        
        Thanks for thrusting us!
        """);
        return null;
    }
}
