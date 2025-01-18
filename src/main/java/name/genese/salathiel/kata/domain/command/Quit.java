package name.genese.salathiel.kata.domain.command;

import name.genese.salathiel.kata.service.AccountService;

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
