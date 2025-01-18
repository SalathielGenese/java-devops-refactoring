package name.genese.salathiel.kata.service.internal;

import name.genese.salathiel.kata.domain.command.Command;
import name.genese.salathiel.kata.domain.command.Menu;
import name.genese.salathiel.kata.domain.command.Quit;
import name.genese.salathiel.kata.service.AccountService;
import name.genese.salathiel.kata.service.ConsoleRouter;

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
