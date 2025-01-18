package name.genese.salathiel.kata.console.service;

import name.genese.salathiel.kata.console.service.internal.ConsoleRouterDefault;
import name.genese.salathiel.kata.core.service.AccountService;

import java.util.Scanner;
import java.util.function.Consumer;

public interface ConsoleRouter {
    void route();

    static ConsoleRouter from(AccountService accountService,
                              Consumer<Exception> onError,
                              Scanner scanner) {
        return new ConsoleRouterDefault(accountService, onError, scanner);
    }

    static ConsoleRouter from(AccountService accountService,
                              Scanner scanner) {
        return new ConsoleRouterDefault(accountService, scanner);
    }
}
