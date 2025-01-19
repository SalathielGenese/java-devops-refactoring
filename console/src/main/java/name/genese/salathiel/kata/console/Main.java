package name.genese.salathiel.kata.console;

import name.genese.salathiel.kata.console.service.ConsoleRouter;
import name.genese.salathiel.kata.core.service.AccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.err.println("""
        WELCOME TO @SalathielGenese BANK
          + https://salathiel.genese.name
          + https://www.linkedin.com/in/salathielgenese
          + https://github.com/SalathielGenese/java-devops-refactoring
        
        """);
        ConsoleRouter.from(
                AccountService.from(),
                e -> System.err.printf("   %s%n", e.getMessage()),
                new Scanner(System.in)
        ).route();
    }
}
