package name.genese.salathiel.kata.console.service.internal;

import name.genese.salathiel.kata.console.domain.Command;
import name.genese.salathiel.kata.console.domain.Menu;
import name.genese.salathiel.kata.console.domain.Quit;
import name.genese.salathiel.kata.core.service.AccountService;
import name.genese.salathiel.kata.console.service.ConsoleRouter;

import java.util.Scanner;
import java.util.function.Consumer;

public record ConsoleRouterDefault(AccountService accountService,
                                   Consumer<Exception> onError,
                                   Scanner scanner)
        implements ConsoleRouter {
    public ConsoleRouterDefault(AccountService accountService, Scanner scanner) {
        // @formatter:off
        this(accountService, _ -> {}, scanner);
        // @formatter:on
    }

    @Override
    public void route() {
        for (Command next = new Menu(); ; next = next.visit(accountService, onError, scanner)) {
            switch (next) {
                case Quit _ -> {
                    next.visit(accountService, onError, scanner);
                    return;
                }
                case null -> next = new Menu();
                default -> {
                }
            }
        }
    }
}
