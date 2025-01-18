package name.genese.salathiel.kata.console.domain;

import name.genese.salathiel.kata.core.service.AccountService;

import java.util.Scanner;
import java.util.function.Consumer;

public record Menu() implements Command {
    @Override
    public Command visit(AccountService accountService, Consumer<Exception> onError, Scanner scanner) {
        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.err.println("""
        
        1. Print Statement
        2. Make Withdrawal
        3. Make Deposit
        0. Quit
        """);
        System.err.print("   > ");
        return switch (scanner.nextLine()) {
            case "1" -> new PrintStatement();
            case "2" -> new MakeWithdrawal();
            case "3" -> new MakeDeposit();
            case "0" -> new Quit();
            default -> new Menu();
        };
    }
}
