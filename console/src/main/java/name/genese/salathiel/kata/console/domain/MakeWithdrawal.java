package name.genese.salathiel.kata.console.domain;

import name.genese.salathiel.kata.core.service.AccountService;

import java.util.Scanner;
import java.util.function.Consumer;

public record MakeWithdrawal() implements Command {
    @Override
    public Command visit(AccountService accountService, Consumer<Exception> onError, Scanner scanner) {
        System.err.println("   WITHDRAWAL AMOUNT");
        System.err.print("   > ");
        try {
            accountService.withdraw(Double.parseDouble(scanner.nextLine()));
        } catch (Exception e) {
            onError.accept(e);
        }
        return null;
    }
}
