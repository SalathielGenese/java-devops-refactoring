package name.genese.salathiel.kata.domain.command;

import name.genese.salathiel.kata.service.AccountService;

import java.util.Scanner;
import java.util.function.Consumer;

public sealed interface Command permits MakeDeposit, MakeWithdrawal, Menu, PrintStatement, Quit {
    Command visit(AccountService accountService, Consumer<Exception> onError, Scanner scanner);
}
