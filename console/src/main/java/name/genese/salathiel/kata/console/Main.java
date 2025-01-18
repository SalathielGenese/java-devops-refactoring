package name.genese.salathiel.kata.console;

import name.genese.salathiel.kata.console.service.internal.ConsoleRouterDefault;
import name.genese.salathiel.kata.core.service.internal.AccountServiceDefault;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new ConsoleRouterDefault(
                new AccountServiceDefault(),
                e -> System.err.printf("   %s%n", e.getMessage()),
                new Scanner(System.in)
        ).route();
    }
}
