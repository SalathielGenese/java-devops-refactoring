package name.genese.salathiel.kata.domain.command;

import name.genese.salathiel.kata.service.AccountService;

import java.util.Scanner;
import java.util.function.Consumer;

public record MakeDeposit() implements Command {
    @Override
    public Command visit(AccountService accountService, Consumer<Exception> onError, Scanner scanner) {
        System.err.println("   DEPOSIT AMOUNT");
        System.err.print("   > ");
        try {
            accountService.deposit(Double.parseDouble(scanner.nextLine()));
        } catch (Exception e) {
            onError.accept(e);
        }
        return null;
    }
}
