package name.genese.salathiel.kata.internal;

import name.genese.salathiel.kata.AccountService;

import java.math.BigDecimal;
import java.util.Objects;

public final class AccountServiceDefault implements AccountService {
    private BigDecimal balance;

    public AccountServiceDefault(BigDecimal initial) {
        Objects.requireNonNull(initial, "balance is null");
        if (initial.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("negative balance");
        }

        this.balance = initial;
    }

    public AccountServiceDefault() {
        this(BigDecimal.ZERO);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("negative amount");
        balance = balance.add(BigDecimal.valueOf(amount));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("negative amount");
        if (0 < BigDecimal.valueOf(amount).compareTo(balance))
            throw new IllegalArgumentException("insufficient balance");
        balance = balance.subtract(BigDecimal.valueOf(amount));
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}
