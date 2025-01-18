package name.genese.salathiel.kata.domain.command;

import name.genese.salathiel.kata.service.AccountService;

import java.util.Scanner;
import java.util.function.Consumer;

public record Menu() implements Command {
    @Override
    public Command visit(AccountService accountService, Consumer<Exception> onError, Scanner scanner) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
