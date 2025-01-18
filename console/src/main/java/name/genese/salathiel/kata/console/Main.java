package name.genese.salathiel.kata.console;

import name.genese.salathiel.kata.console.service.ConsoleRouter;
import name.genese.salathiel.kata.core.service.AccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleRouter.from(
                AccountService.from(),
                e -> System.err.printf("   %s%n", e.getMessage()),
                new Scanner(System.in)
        ).route();
    }
}
