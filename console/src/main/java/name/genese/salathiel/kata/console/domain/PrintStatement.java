package name.genese.salathiel.kata.console.domain;

import name.genese.salathiel.kata.core.domain.Operation;
import name.genese.salathiel.kata.core.service.AccountService;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Consumer;

public record PrintStatement() implements Command {
    @Override
    public Command visit(AccountService accountService, Consumer<Exception> onError, Scanner scanner) {
        final var df = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").withZone(ZoneId.systemDefault());
        System.err.print(
        """
           STATEMENT
           ______________________________________________________________
           |                DATE |      DEBIT |     CREDIT |    BALANCE |
           --------------------------------------------------------------
        """);
        accountService.getStatement().reversed().forEach(operation -> {
            switch (operation) {
                case Operation.Withdrawal(BigDecimal balance, BigDecimal amount, Instant date) ->
                    System.err.printf(
                    """
                       | %10s | %10.2f | %10s | %10.2f |
                       %s
                    """, df.format(date), amount, "", balance, "-".repeat(62));
                case Operation.Deposit(BigDecimal balance, BigDecimal amount, Instant date) ->
                    System.err.printf(
                    """
                       | %10s | %10s | %10.2f | %10.2f |
                       %s
                    """, df.format(date), "", amount, balance, "-".repeat(62));
                case Operation.Initial(BigDecimal balance, BigDecimal amount, Instant date) ->
                    System.err.printf(
                    """
                       | %10s | %10s | %10.2f | %10.2f |
                       %s
                    """, df.format(date), "", amount, balance, "-".repeat(62));
            }
        });
        return null;
    }
}
