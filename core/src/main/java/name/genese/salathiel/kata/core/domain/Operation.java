package name.genese.salathiel.kata.core.domain;

import java.math.BigDecimal;
import java.time.Instant;

public sealed interface Operation {
    BigDecimal balance();

    BigDecimal amount();

    Instant date();

    record Initial(BigDecimal balance, BigDecimal amount, Instant date) implements Operation {
        public Initial(BigDecimal balance, BigDecimal amount) {
            this(balance, amount, Instant.now());
        }
    }

    record Deposit(BigDecimal balance, BigDecimal amount, Instant date) implements Operation {
        public Deposit(BigDecimal balance, BigDecimal amount) {
            this(balance, amount, Instant.now());
        }
    }

    record Withdrawal(BigDecimal balance, BigDecimal amount, Instant date) implements Operation {
        public Withdrawal(BigDecimal balance, BigDecimal amount) {
            this(balance, amount, Instant.now());
        }
    }
}
